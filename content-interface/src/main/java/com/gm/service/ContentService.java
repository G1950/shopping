package com.gm.service;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbContent;

import java.util.List;

public interface ContentService {
    Result  findAll();

    PageResult findPage(Integer pageNo, Integer pageSize);

    Result findPage(TbContent content, Integer pageNo, Integer pageSize);

    Result saveContent(TbContent  content);

    Result updateContent(TbContent content);

    Result deleteContent(Long[] ids);

    Result deleteOneContent(Long id);
}
