package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSpecificationOption;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("SELLERGOODS-SERVICE")
public interface SpecificationOptionFeignClient {

    @GetMapping("/specificationOption")
    Result findAll();

    @GetMapping("/specificationOption/{pageNo}/{pageSize}")
    PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

    @PostMapping("/specificationOption/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbSpecificationOption specificationOption, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


    @PostMapping("/specificationOption")
    Result saveSpecificationOption(@RequestBody List<TbSpecificationOption> specificationOption);

    @PutMapping("/specificationOption")
    Result updateSpecificationOption(@RequestBody List<TbSpecificationOption> specificationOption);

    @DeleteMapping("/specificationOption")
    Result deleteSpecificationOption(@RequestParam("ids") Long[] ids);

    @GetMapping("/specificationOption/{id}")
    Result findOne(@PathVariable("id") Long specId);
}
