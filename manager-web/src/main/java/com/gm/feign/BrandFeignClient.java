package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbBrand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("SELLERGOODS-SERVICE")
public interface BrandFeignClient{

@GetMapping("/brand")
Result findAll();

@GetMapping("/brand/{pageNo}/{pageSize}")
PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

@PostMapping("/brand/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbBrand brand,@PathVariable("pageNo") Integer pageNo,@PathVariable("pageSize") Integer pageSize);


@PostMapping("/brand")
    Result saveBrand(@RequestBody TbBrand brand);

@PutMapping("/brand")
    Result updateBrand(@RequestBody TbBrand brand);

@DeleteMapping("/brand")
    Result deleteBrand(@RequestParam("ids") Long[]ids);

        }
