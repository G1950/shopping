package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSpecification;
import com.gm.service.SpecificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SpecificationController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    private final SpecificationService specificationService;

    public SpecificationController(SpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @GetMapping("")
    public Result findAllSpecification() {
        return specificationService.findAll();
    }

    @PostMapping("")
    public Result saveSpecification(@RequestBody TbSpecification specification) {
        return specificationService.saveSpecification(specification);
    }

    @PutMapping("")
    public Result updateSpecification(@RequestBody TbSpecification specification) {
        return specificationService.updateSpecification(specification);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneSpecification(@PathVariable("id") Long id) {
        return specificationService.deleteOneSpecification(id);
    }

    @DeleteMapping("")
    public Result deleteSpecification(@RequestParam("ids") Long[] ids) {
        return specificationService.deleteSpecification(ids);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageSpecification(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageSpecification(@RequestBody TbSpecification specification, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationService.findPage(specification, pageNo, pageSize);
    }
}
