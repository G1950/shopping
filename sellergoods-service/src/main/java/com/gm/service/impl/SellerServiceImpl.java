package com.gm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbSellerMapper;
import com.gm.pojo.TbSeller;
import com.gm.pojo.TbSellerExample;
import com.gm.service.SellerService;
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
public class SellerServiceImpl implements SellerService {

    @Resource
    private TbSellerMapper tbSellerMapper;


    @Override
    public Result findAll() {
        try {
            List<TbSeller> tbSellers = tbSellerMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbSellers);
        } catch (Exception e) {
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbSeller> page = (Page<TbSeller>) tbSellerMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbSeller seller, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbSeller> page;
        TbSellerExample example = new TbSellerExample();
        TbSellerExample.Criteria criteria = example.createCriteria();
        if (seller != null) {
            if (seller.getStatus() != null && seller.getStatus().length() > 0)
                criteria.andStatusEqualTo(seller.getStatus());

            if (seller.getName() != null && seller.getName().length() > 0)
                criteria.andNameLike("%" + seller.getName() + "%");
            if (seller.getNickName() != null && seller.getNickName().length() > 0)
                criteria.andNickNameLike("%" + seller.getNickName() + "%");
        }
        page = (Page<TbSeller>) tbSellerMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveSeller(TbSeller seller) {
        try {
            TbSellerExample example = new TbSellerExample();
            TbSellerExample.Criteria criteria = example.createCriteria();
            criteria.andSellerIdEqualTo(seller.getSellerId());
            List<TbSeller> tbSellers = tbSellerMapper.selectByExample(example);
            if (tbSellers.size() != 0)
                return Result.build(ResultEnum.Seller_EXIST);
            tbSellerMapper.insert(seller);
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateSeller(TbSeller seller) {
        try {
            TbSeller tbSeller = tbSellerMapper.selectByPrimaryKey(seller.getSellerId());
            if (tbSeller == null)
                return Result.build(ResultEnum.Seller_NOT_EXIST);
            tbSellerMapper.updateByPrimaryKeySelective(seller);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteSeller(String[] ids) {
        try {
            for (String id : ids) {
                tbSellerMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result deleteOneSeller(String id) {
        try {
            tbSellerMapper.deleteByPrimaryKey(id);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
