package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.TypeTemplateFeignClient;
import com.gm.pojo.TbTypeTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName TypeTemplateController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class TypeTemplateController {
    private final TypeTemplateFeignClient typeTemplateFeignClient;

    public TypeTemplateController(TypeTemplateFeignClient typeTemplateFeignClient) {

        this.typeTemplateFeignClient = typeTemplateFeignClient;
    }

    @GetMapping("/typeTemplate")
    public Result findAll() {
        return typeTemplateFeignClient.findAll();
    }

    @GetMapping("/typeTemplate/{id}")
    public Result findTemplateById(@PathVariable("id") Long id) {
        return typeTemplateFeignClient.findTemplateById(id);
    }

    @GetMapping("/typeTemplate/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return typeTemplateFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/typeTemplate/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbTypeTemplate typeTemplate, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return typeTemplateFeignClient.searchPage(typeTemplate, pageNo, pageSize);
    }

    @PostMapping("/typeTemplate")
    public Result saveTypeTemplate(@RequestBody TbTypeTemplate typeTemplate) {
        return typeTemplateFeignClient.saveTypeTemplate(typeTemplate);
    }

    @PutMapping("/typeTemplate")
    public Result updateTypeTemplate(@RequestBody TbTypeTemplate typeTemplate) {
        return typeTemplateFeignClient.updateTypeTemplate(typeTemplate);
    }

    @DeleteMapping("/typeTemplate")
    public Result deleteTypeTemplate(Long[] ids) {
        return typeTemplateFeignClient.deleteTypeTemplate(ids);
    }

    @DeleteMapping("/typeTemplate/{id}")
    public Result deleteOneTypeTemplate(@PathVariable("id") Long id) {
        return typeTemplateFeignClient.deleteOneTypeTemplate(id);
    }


}
