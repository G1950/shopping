package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbBrand;

import java.util.List;

public interface BrandService {
    Result findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbBrand brand, Integer pageNo, Integer pageSize);

    Result saveBrand(TbBrand brand);

    Result updateBrand(TbBrand brand);

    Result deleteBrand(Long[] ids);

    Result deleteOneBrand(Long id);
}
