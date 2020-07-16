package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.SpecificationFeignClient;
import com.gm.pojo.TbSpecification;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName SpecificationController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class SpecificationController {
    private final SpecificationFeignClient specificationFeignClient;

    public SpecificationController(SpecificationFeignClient specificationFeignClient) {

        this.specificationFeignClient = specificationFeignClient;
    }

    @GetMapping("/specification")
    public Result findAll() {
        return specificationFeignClient.findAll();
    }

    @GetMapping("/specification/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/specification/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbSpecification specification, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationFeignClient.searchPage(specification, pageNo, pageSize);
    }

    @PostMapping("/specification")
    public Result saveSpecification(@RequestBody TbSpecification specification) {
        return specificationFeignClient.saveSpecification(specification);
    }

    @PutMapping("/specification")
    public Result updateSpecification(@RequestBody TbSpecification specification) {
        return specificationFeignClient.updateSpecification(specification);
    }

    @DeleteMapping("/specification")
    public Result deleteSpecification(Long[] ids) {
        return specificationFeignClient.deleteSpecification(ids);
    }

    @DeleteMapping("/specification/{id}")
    public Result deleteSpecification(@PathVariable("id") Long id) {
        return specificationFeignClient.deleteOneSpecification(id);
    }


}
