package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbGoodsDesc;

import java.util.List;

public interface GoodsDescService {
    Result findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbGoodsDesc goodsDesc, Integer pageNo, Integer pageSize);

    Result saveGoodsDesc(TbGoodsDesc goodsDesc);

    Result updateGoodsDesc(TbGoodsDesc goodsDesc);

    Result deleteGoodsDesc(Long[] ids);

    Result deleteOneGoodsDesc(Long id);
}
