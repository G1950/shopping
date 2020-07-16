package com.gm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbGoodsDescMapper;
import com.gm.mapper.TbGoodsMapper;
import com.gm.pojo.Goods;
import com.gm.pojo.TbGoods;
import com.gm.pojo.TbGoodsExample;
import com.gm.service.GoodsService;
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
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private TbGoodsMapper tbGoodsMapper;
    @Resource
    private TbGoodsDescMapper tbGoodsDescMapper;


    @Override
    public Result findAll() {
        try {
            List<TbGoods> tbGoods = tbGoodsMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbGoods);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbGoods> page = (Page<TbGoods>) tbGoodsMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(Goods goods, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbGoods> page;
        TbGoodsExample example = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = example.createCriteria();
//        if (goods != null) {
//            if (goods.getName() != null && goods.getName().length() > 0)
//                criteria.andNameLike("%" + goods.getName() + "%");
//            if (goods.getFirstChar() != null && goods.getFirstChar().length() > 0)
//                criteria.andFirstCharEqualTo(goods.getFirstChar());
//        }
        page = (Page<TbGoods>) tbGoodsMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveGoods(Goods goods) {
        try {
            goods.getGoods().setAuditStatus("0");
            tbGoodsMapper.insert(goods.getGoods());
            goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
            tbGoodsDescMapper.insert(goods.getGoodsDesc());
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateGoods(Goods goods) {
        try {
            tbGoodsMapper.updateByPrimaryKeySelective(goods.getGoods());
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteGoods(Long[] ids) {
        try {
            for (Long id : ids) {
                tbGoodsMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result deleteOneGoods(Long id) {
        try {
            tbGoodsMapper.deleteByPrimaryKey(id);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
