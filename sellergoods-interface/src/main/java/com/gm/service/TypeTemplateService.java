package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbTypeTemplate;

import java.util.List;

public interface TypeTemplateService {
    Result findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbTypeTemplate typeTemplate, Integer pageNo, Integer pageSize);

    Result saveTypeTemplate(TbTypeTemplate typeTemplate);

    Result updateTypeTemplate(TbTypeTemplate typeTemplate);

    Result deleteTypeTemplate(Long[] ids);

    Result deleteOneTypeTemplate(Long id);

    Result findTemplateById(Long id);
}
