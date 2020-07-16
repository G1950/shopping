package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbGoodsDescMapper;
import com.gm.pojo.TbGoodsDesc;
import com.gm.pojo.TbGoodsDescExample;
import com.gm.service.GoodsDescService;
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
public class GoodsDescServiceImpl implements GoodsDescService {

    @Resource
    private TbGoodsDescMapper tbGoodsDescMapper;


    @Override
    public Result findAll() {
        try {
            List<TbGoodsDesc> tbGoodsDescs = tbGoodsDescMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbGoodsDescs);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbGoodsDesc> page = (Page<TbGoodsDesc>) tbGoodsDescMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbGoodsDesc goodsDesc, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbGoodsDesc> page;
        TbGoodsDescExample example = new TbGoodsDescExample();
        TbGoodsDescExample.Criteria criteria = example.createCriteria();
//        if (goodsDesc != null) {
//            if (goodsDesc.getName() != null && goodsDesc.getName().length() > 0)
//                criteria.andNameLike("%" + goodsDesc.getName() + "%");
//            if (goodsDesc.getFirstChar() != null && goodsDesc.getFirstChar().length() > 0)
//                criteria.andFirstCharEqualTo(goodsDesc.getFirstChar());
//        }
        page = (Page<TbGoodsDesc>) tbGoodsDescMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveGoodsDesc(TbGoodsDesc goodsDesc) {
        try {
            TbGoodsDescExample example = new TbGoodsDescExample();
            TbGoodsDescExample.Criteria criteria = example.createCriteria();
//            criteria.andNameEqualTo(goodsDesc.getName());
//            List<TbGoodsDesc> tbGoodsDescs = tbGoodsDescMapper.selectByExample(example);
//            if (tbGoodsDescs.size() != 0)
//                return Result.build(ResultEnum.GoodsDesc_EXIST);
            tbGoodsDescMapper.insert(goodsDesc);
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateGoodsDesc(TbGoodsDesc goodsDesc) {
        try {
            tbGoodsDescMapper.updateByPrimaryKeySelective(goodsDesc);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteGoodsDesc(Long[] ids) {
        try {
            for (Long id : ids) {
                tbGoodsDescMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result deleteOneGoodsDesc(Long id) {
        try {
            tbGoodsDescMapper.deleteByPrimaryKey(id);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
