package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbItemCatMapper;
import com.gm.pojo.TbItemCat;
import com.gm.pojo.TbItemCatExample;
import com.gm.service.ItemCatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper tbItemCatMapper;


    @Override
    public Result findAll() {
        try {
            List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbItemCats);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public Result findByParentId(Long id) {

        try {
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(id);
            List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbItemCats);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public Result findById(Long id) {

        try {
            TbItemCat tbItemCat = tbItemCatMapper.selectByPrimaryKey(id);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbItemCat);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbItemCat> page = (Page<TbItemCat>) tbItemCatMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbItemCat itemCat, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbItemCat> page;
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        if (itemCat != null) {
            if (itemCat.getParentId() != null)
                criteria.andParentIdEqualTo(itemCat.getParentId());
            if (itemCat.getName() != null && itemCat.getName().length() > 0)
                criteria.andNameLike("%" + itemCat.getName() + "%");
        }
        page = (Page<TbItemCat>) tbItemCatMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveItemCat(TbItemCat itemCat) {
        try {
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(itemCat.getParentId());
            List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
            if (tbItemCats.size() == 0)
                return Result.build(ResultEnum.ItemCat_NOT_EXIST);
            tbItemCatMapper.insert(itemCat);
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateItemCat(TbItemCat itemCat) {
        try {
            tbItemCatMapper.updateByPrimaryKeySelective(itemCat);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Transactional
    @Override
    public Result deleteItemCat(Long[] ids) {
        try {
            for (Long id : ids) {
                tbItemCatMapper.deleteByPrimaryKey(id);
                deleteByParentId(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result deleteOneItemCat(Long id) {
        try {
            tbItemCatMapper.deleteByPrimaryKey(id);
            deleteByParentId(id);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    //删除根据parentId
    private void deleteByParentId(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        tbItemCatMapper.deleteByExample(example);
    }
}
