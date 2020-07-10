package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbBrandMapper;
import com.gm.pojo.TbBrand;
import com.gm.pojo.TbBrandExample;
import com.gm.service.BrandService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private TbBrandMapper tbBrandMapper;


    @Override
    public Result findAll() {
        try {
            List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbBrands);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbBrand brand, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbBrand> page;
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (brand.getName() != null && brand.getName().length() > 0)
                criteria.andNameLike("%" + brand.getName() + "%");
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0)
                criteria.andFirstCharEqualTo(brand.getFirstChar());
        }
        page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveBrand(TbBrand brand) {
        try {
            tbBrandMapper.insert(brand);

            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            log.info("添加异常：" + e.getMessage());
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateBrand(TbBrand brand) {
        try {
            tbBrandMapper.updateByPrimaryKeySelective(brand);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteBrand(Long[] ids) {
        try {
            for (Long id : ids) {
                tbBrandMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
