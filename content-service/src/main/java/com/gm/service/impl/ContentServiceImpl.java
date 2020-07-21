package com.gm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.mapper.TbContentMapper;
import com.gm.pojo.TbContent;
import com.gm.pojo.TbContentExample;
import com.gm.service.ContentService;
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
public class ContentServiceImpl implements ContentService {

    @Resource
    private TbContentMapper tbContentMapper;


    @Override
    public Result findAll() {
        try {
            List<TbContent> tbContents = tbContentMapper.selectByExample(null);
            return Result.build(ResultEnum.QUERY_SUCCESS, tbContents);
        }catch (Exception e){
            return Result.build(ResultEnum.QUERY_ERROR);
        }
    }

    @Override
    public PageResult findPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbContent> page = (Page<TbContent>) tbContentMapper.selectByExample(null);
        return PageResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public Result findPage(TbContent content, Integer pageNo, Integer pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Page<TbContent> page;
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        if (content != null) {
            if (content.getTitle() != null && content.getTitle().length() > 0)
                criteria.andTitleLike("%" + content.getTitle() + "%");
        }
        page = (Page<TbContent>) tbContentMapper.selectByExample(example);
        return Result.build(ResultEnum.SUCCESS, PageResult.build(page.getTotal(), page.getResult()));
    }


    @Override
    public Result saveContent(TbContent content) {
        try {
//            TbContentExample example = new TbContentExample();
//            TbContentExample.Criteria criteria = example.createCriteria();
//            criteria.andNameEqualTo(typeTemplate.getName());
//            List<TbContent> tbContents = tbContentMapper.selectByExample(example);
//            if (tbContents.size() != 0)
//                return Result.build(ResultEnum.Content_EXIST);
            tbContentMapper.insert(content);
            return Result.build(ResultEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.SAVE_ERROR);
        }
    }

    @Override
    public Result updateContent(TbContent content) {
        try {
            tbContentMapper.updateByPrimaryKeySelective(content);
            return Result.build(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    public Result deleteContent(Long[] ids) {
        try {
            for (Long id : ids) {
                tbContentMapper.deleteByPrimaryKey(id);
            }
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }

@Override
    public Result deleteOneContent(Long id) {
        try {
            tbContentMapper.deleteByPrimaryKey(id);
            return Result.build(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            return Result.build(ResultEnum.DELETE_ERROR);
        }
    }
}
