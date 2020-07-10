package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSpecificationOption;

import java.util.List;

public interface SpecificationOptionService {
    List<TbSpecificationOption> findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbSpecificationOption specificationOption, Integer pageNo, Integer pageSize);

    Result saveSpecificationOption(List<TbSpecificationOption> specificationOption);

    Result updateSpecificationOption(TbSpecificationOption specificationOption);

    Result deleteSpecificationOption(Long[] ids);

    Result findOne(Long specId);
}
