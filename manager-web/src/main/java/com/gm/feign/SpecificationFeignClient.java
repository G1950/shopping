package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSpecification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("SELLERGOODS-SERVICE")
public interface SpecificationFeignClient {

    @GetMapping("/specification")
    Result findAll();

    @GetMapping("/specification/{pageNo}/{pageSize}")
    PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

    @PostMapping("/specification/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbSpecification specification, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


    @PostMapping("/specification")
    Result saveSpecification(@RequestBody TbSpecification specification);

    @PutMapping("/specification")
    Result updateSpecification(@RequestBody TbSpecification specification);

    @DeleteMapping("/specification")
    Result deleteSpecification(@RequestParam("ids") Long[] ids);

}
