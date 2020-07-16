package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbItemCat;

import java.util.List;

public interface ItemCatService {
    Result findAll();

    Result findByParentId(Long id);

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbItemCat itemCat, Integer pageNo, Integer pageSize);

    Result saveItemCat(TbItemCat itemCat);

    Result updateItemCat(TbItemCat itemCat);

    Result deleteItemCat(Long[] ids);

    Result deleteOneItemCat(Long id);

    Result findById(Long id);
}
