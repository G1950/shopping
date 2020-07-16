package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("SELLERGOODS-SERVICE")
public interface GoodsFeignClient {

    @GetMapping("/goods")
    Result findAll();

    @GetMapping("/goods/{pageNo}/{pageSize}")
    PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

    @PostMapping("/goods/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody Goods goods, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


    @PostMapping("/goods")
    Result saveGoods(@RequestBody Goods goods);

    @PutMapping("/goods")
    Result updateGoods(@RequestBody Goods goods);

    @DeleteMapping("/goods")
    Result deleteGoods(@RequestParam("ids") Long[] ids);

    @DeleteMapping("/goods/{id}")
    Result deleteOneGoods(@PathVariable("id") Long id);
}
