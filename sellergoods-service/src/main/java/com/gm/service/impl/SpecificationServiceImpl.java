package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbSpecificationMapper;
import com.gm.pojo.TbSpecification;
import com.gm.pojo.TbSpecificationExample;
import com.gm.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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


    @Override
    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
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


    @Override
    public Result saveSpecification(TbSpecification specification) {
        try {
            tbSpecificationMapper.insert(specification);
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateSpecification(TbSpecification specification) {
        try {
            TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(specification.getId());
            if (tbSpecification==null)
            {
                return Result.build(ResultEnum.SPECIFICATION_NOT_EXIST);
            }
            tbSpecificationMapper.updateByPrimaryKeySelective(specification);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteSpecification(Long[] ids) {
        try {
            for (Long id : ids) {
                tbSpecificationMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
