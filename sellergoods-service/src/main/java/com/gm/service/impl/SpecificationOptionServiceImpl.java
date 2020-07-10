package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbSpecificationOptionMapper;
import com.gm.pojo.TbSpecificationOption;
import com.gm.pojo.TbSpecificationOptionExample;
import com.gm.service.SpecificationOptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName specificationOptionServiceImpl
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:47
 * @Version 1.0
 **/
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Resource
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;


    @Override
    public List<TbSpecificationOption> findAll() {
        return tbSpecificationOptionMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbSpecificationOption> page = (Page<TbSpecificationOption>) tbSpecificationOptionMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbSpecificationOption specificationOption, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbSpecificationOption> page;
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        if (specificationOption != null) {
            if (specificationOption.getOptionName() != null && specificationOption.getOptionName().length() > 0)
                criteria.andOptionNameLike("%" + specificationOption.getOptionName() + "%");

        }
        page = (Page<TbSpecificationOption>) tbSpecificationOptionMapper.selectByExample(example);
        return Result.build(ResultEnum.QUERY_SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Transactional
    @Override
    public Result saveSpecificationOption(List<TbSpecificationOption> specificationOptions) {
        try {
            for (TbSpecificationOption specificationOption : specificationOptions) {
                tbSpecificationOptionMapper.insert(specificationOption);
            }
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateSpecificationOption(TbSpecificationOption specificationOption) {
        try {
            TbSpecificationOption tbSpecificationOption = tbSpecificationOptionMapper.selectByPrimaryKey(specificationOption.getId());
            if (tbSpecificationOption == null)
                return Result.build(ResultEnum.SPECIFIC_NOT_EXIST);
            tbSpecificationOptionMapper.updateByPrimaryKeySelective(specificationOption);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteSpecificationOption(Long[] ids) {
        try {
            for (Long id : ids) {
                tbSpecificationOptionMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result findOne(Long specId) {
        try {
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(specId);
            List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.selectByExample(example);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbSpecificationOptions);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }
}
