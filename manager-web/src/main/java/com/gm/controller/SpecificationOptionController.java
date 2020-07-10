package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.SpecificationOptionFeignClient;
import com.gm.pojo.TbSpecificationOption;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName SpecificationOptionController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class SpecificationOptionController {
    private final SpecificationOptionFeignClient specificationOptionFeignClient;

    public SpecificationOptionController(SpecificationOptionFeignClient specificationOptionFeignClient) {

        this.specificationOptionFeignClient = specificationOptionFeignClient;
    }

    @GetMapping("/specificationOption")
    public Result findAll() {
        return specificationOptionFeignClient.findAll();
    }
    @GetMapping("/specificationOption/{id}")
    public Result findOne(@PathVariable("id")Long specId) {
        return specificationOptionFeignClient.findOne(specId);
    }

    @GetMapping("/specificationOption/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationOptionFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/specificationOption/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbSpecificationOption specificationOption, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationOptionFeignClient.searchPage(specificationOption, pageNo, pageSize);
    }

    @PostMapping("/specificationOption")
    public Result saveSpecificationOption(@RequestBody List<TbSpecificationOption> specificationOption) {
        return specificationOptionFeignClient.saveSpecificationOption(specificationOption);
    }

    @PutMapping("/specificationOption")
    public Result updateSpecificationOption(@RequestBody TbSpecificationOption specificationOption) {
        return specificationOptionFeignClient.updateSpecificationOption(specificationOption);
    }

    @DeleteMapping("/specificationOption")
    public Result deleteSpecificationOption(Long[] ids) {
        return specificationOptionFeignClient.deleteSpecificationOption(ids);
    }


}
