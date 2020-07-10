package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSpecificationOption;
import com.gm.service.SpecificationOptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SpecificationOptionController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/specificationOption")
public class SpecificationOptionController {

    private final SpecificationOptionService specificationOptionService;

    public SpecificationOptionController(SpecificationOptionService specificationOptionService) {
        this.specificationOptionService = specificationOptionService;
    }

    @GetMapping("")
    public List<TbSpecificationOption> findAllSpecificationOption() {
        return specificationOptionService.findAll();
    }

    @GetMapping("/{id}")
    Result findOne(@PathVariable("id") Long specId){
       return  specificationOptionService.findOne(specId);
    }
    @PostMapping("")
    public Result saveSpecificationOption(@RequestBody List<TbSpecificationOption> specificationOption) {
        return specificationOptionService.saveSpecificationOption(specificationOption);
    }

    @PutMapping("")
    public Result updateSpecificationOption(@RequestBody TbSpecificationOption specificationOption) {
        return specificationOptionService.updateSpecificationOption(specificationOption);
    }

    @DeleteMapping("")
    public Result deleteSpecificationOption(@RequestParam("ids") Long[] ids) {
        return specificationOptionService.deleteSpecificationOption(ids);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageSpecificationOption(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationOptionService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageSpecificationOption(@RequestBody TbSpecificationOption specificationOption, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return specificationOptionService.findPage(specificationOption, pageNo, pageSize);
    }
}
