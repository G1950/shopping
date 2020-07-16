package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSeller;

import java.util.List;

public interface SellerService {
    Result findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbSeller seller, Integer pageNo, Integer pageSize);

    Result saveSeller(TbSeller seller);

    Result updateSeller(TbSeller seller);

    Result deleteSeller(String[] ids);

    Result deleteOneSeller(String id);
}
