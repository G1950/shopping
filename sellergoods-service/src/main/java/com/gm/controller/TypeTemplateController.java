package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbTypeTemplate;
import com.gm.service.TypeTemplateService;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TypeTemplateController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    private final TypeTemplateService typeTemplateService;

    public TypeTemplateController(TypeTemplateService typeTemplateService) {
        this.typeTemplateService = typeTemplateService;
    }

    @GetMapping("")
    public Result findAllTypeTemplate() {
        return typeTemplateService.findAll();
    }

    @GetMapping("/{id}")
    public Result findTemplateById(@PathVariable("id") Long id) {
        return typeTemplateService.findTemplateById(id);
    }

    @PostMapping("")
    public Result saveTypeTemplate(@RequestBody TbTypeTemplate typeTemplate) {
        return typeTemplateService.saveTypeTemplate(typeTemplate);
    }

    @PutMapping("")
    public Result updateTypeTemplate(@RequestBody TbTypeTemplate typeTemplate) {
        return typeTemplateService.updateTypeTemplate(typeTemplate);
    }

    @DeleteMapping("")
    public Result deleteTypeTemplate(@RequestParam("ids") Long[] ids) {
        return typeTemplateService.deleteTypeTemplate(ids);
    }

    @DeleteMapping("/{id}")
    Result deleteOneTypeTemplate(@PathVariable("id") Long id) {
        return typeTemplateService.deleteOneTypeTemplate(id);

    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageTypeTemplate(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return typeTemplateService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageTypeTemplate(@RequestBody TbTypeTemplate typeTemplate, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return typeTemplateService.findPage(typeTemplate, pageNo, pageSize);
    }
}
