package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbSpecificationMapper;
import com.gm.mapper.TbSpecificationOptionMapper;
import com.gm.pojo.TbSpecification;
import com.gm.pojo.TbSpecificationExample;
import com.gm.pojo.TbSpecificationOption;
import com.gm.pojo.TbSpecificationOptionExample;
import com.gm.service.SpecificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName specificationServiceImpl
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:47
 * @Version 1.0
 **/
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private TbSpecificationMapper tbSpecificationMapper;
    @Resource
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;


    @Override
    public Result findAll() {
        try {
            return Result.build(ResultEnum.QUERY_SUCCESS, tbSpecificationMapper.selectByExample(null));
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbSpecification specification, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbSpecification> page;
        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        if (specification != null) {

            if (specification.getSpecName() != null && specification.getSpecName().length() > 0)

                criteria.andSpecNameLike("%" + specification.getSpecName() + "%");

        }

        page = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(example);
        return Result.build(ResultEnum.QUERY_SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Transactional
    @Override
    public Result saveSpecification(TbSpecification specification) {
        try {
            TbSpecificationExample example = new TbSpecificationExample();
            TbSpecificationExample.Criteria criteria = example.createCriteria();
            criteria.andSpecNameEqualTo(specification.getSpecName());
            List<TbSpecification> tbSpecifications = tbSpecificationMapper.selectByExample(example);
            if (tbSpecifications.size() != 0)
                return Result.build(ResultEnum.SPECIFICATION_EXIST);
            tbSpecificationMapper.insert(specification);
            tbSpecifications = tbSpecificationMapper.selectByExample(example);
            specificationOption(specification.getSpecificationOptionList(), tbSpecifications.get(0).getId());
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Transactional
    @Override
    public Result updateSpecification(TbSpecification specification) {
        try {
            TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(specification.getId());
            if (tbSpecification == null) {
                return Result.build(ResultEnum.SPECIFICATION_NOT_EXIST);
            }
            tbSpecificationMapper.updateByPrimaryKeySelective(specification);
            specificationOption(specification.getSpecificationOptionList(), specification.getId());
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Transactional
    @Override
    public Result deleteSpecification(Long[] ids) {
        try {
            for (Long id : ids) {
                tbSpecificationMapper.deleteByPrimaryKey(id);
            }
            deleteSpecificationOption(ids);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Transactional
    @Override
    public Result deleteOneSpecification(Long id) {
        try {
            Long[] ids = new Long[]{id};
            tbSpecificationMapper.deleteByPrimaryKey(id);
            deleteSpecificationOption(ids);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    private void specificationOption(List<TbSpecificationOption> specificationOptions, Long specId) {
        for (TbSpecificationOption specificationOption : specificationOptions) {
            specificationOption.setSpecId(specId);
            if (specificationOption.getId() == null) {
                tbSpecificationOptionMapper.insert(specificationOption);
            } else {
                tbSpecificationOptionMapper.updateByPrimaryKey(specificationOption);
            }
        }

    }

    private void deleteSpecificationOption(Long[] ids) {
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdIn(Arrays.asList(ids));
        tbSpecificationOptionMapper.deleteByExample(example);
    }
}
