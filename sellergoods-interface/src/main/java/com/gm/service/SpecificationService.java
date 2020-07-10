package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSpecification;

import java.util.List;

public interface SpecificationService {
    List<TbSpecification> findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbSpecification specification, Integer pageNo, Integer pageSize);

    Result saveSpecification(TbSpecification brand);

    Result updateSpecification(TbSpecification specification);

    Result deleteSpecification(Long[] ids);
}
