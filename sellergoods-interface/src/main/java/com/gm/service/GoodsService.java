package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.Goods;

public interface GoodsService {
    Result findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(Goods goods, Integer pageNo, Integer pageSize);

    Result saveGoods(Goods goods);

    Result updateGoods(Goods goods);

    Result deleteGoods(Long[] ids);

    Result deleteOneGoods(Long id);
}
