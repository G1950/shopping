package com.gm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbTypeTemplateMapper;
import com.gm.pojo.TbTypeTemplate;
import com.gm.pojo.TbTypeTemplateExample;
import com.gm.service.TypeTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BrandServiceImpl
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:47
 * @Version 1.0
 **/
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Resource
    private TbTypeTemplateMapper tbTypeTemplateMapper;


    @Override
    public Result findAll() {
        try {
            List<TbTypeTemplate> tbTypeTemplates = tbTypeTemplateMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbTypeTemplates);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbTypeTemplate typeTemplate, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbTypeTemplate> page;
        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();
        if (typeTemplate != null) {
            if (typeTemplate.getName() != null && typeTemplate.getName().length() > 0)
                criteria.andNameLike("%" + typeTemplate.getName() + "%");
        }
        page = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveTypeTemplate(TbTypeTemplate typeTemplate) {
        try {
            TbTypeTemplateExample example = new TbTypeTemplateExample();
            TbTypeTemplateExample.Criteria criteria = example.createCriteria();
            criteria.andNameEqualTo(typeTemplate.getName());
            List<TbTypeTemplate> tbTypeTemplates = tbTypeTemplateMapper.selectByExample(example);
            if (tbTypeTemplates.size() != 0)
                return Result.build(ResultEnum.TYPETEMPLATE_EXIST);
            tbTypeTemplateMapper.insert(typeTemplate);
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {

            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateTypeTemplate(TbTypeTemplate typeTemplate) {
        try {
            tbTypeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteTypeTemplate(Long[] ids) {
        try {
            for (Long id : ids) {
                tbTypeTemplateMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result deleteOneTypeTemplate(Long id) {
        try {

            tbTypeTemplateMapper.deleteByPrimaryKey(id);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result findTemplateById(Long id) {
        try {

            TbTypeTemplate tbTypeTemplate = tbTypeTemplateMapper.selectByPrimaryKey(id);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbTypeTemplate);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
