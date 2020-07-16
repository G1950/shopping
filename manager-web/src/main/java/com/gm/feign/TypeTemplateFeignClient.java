package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbTypeTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("SELLERGOODS-SERVICE")
public interface TypeTemplateFeignClient {

    @GetMapping("/typeTemplate")
    Result findAll();

    @GetMapping("/typeTemplate/{pageNo}/{pageSize}")
    PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

    @PostMapping("/typeTemplate/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbTypeTemplate typeTemplate, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


    @PostMapping("/typeTemplate")
    Result saveTypeTemplate(@RequestBody TbTypeTemplate typeTemplate);

    @PutMapping("/typeTemplate")
    Result updateTypeTemplate(@RequestBody TbTypeTemplate typeTemplate);

    @DeleteMapping("/typeTemplate")
    Result deleteTypeTemplate(@RequestParam("ids") Long[] ids);

    @DeleteMapping("/typeTemplate/{id}")
    Result deleteOneTypeTemplate(@PathVariable("id") Long id);
}
