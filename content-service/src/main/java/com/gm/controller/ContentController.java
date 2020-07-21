package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbContent;
import com.gm.service.ContentService;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("")
    public Result findAllContent() {
        return contentService.findAll();
    }

    @PostMapping("")
    public Result saveContent(@RequestBody TbContent content) {
        return contentService.saveContent(content);
    }

    @PutMapping("")
    public Result updateContent(@RequestBody TbContent content) {
        return contentService.updateContent(content);
    }

    @DeleteMapping("")
    public Result deleteContent(@RequestParam("ids") Long[] ids) {
        return contentService.deleteContent(ids);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneContent(@PathVariable("id") Long id) {
        return contentService.deleteOneContent(id);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageContent(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return contentService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageContent(@RequestBody TbContent content, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return contentService.findPage(content, pageNo, pageSize);
    }
}
