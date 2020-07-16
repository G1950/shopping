package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("SELLERGOODS-SERVICE")
public interface ItemCatFeignClient {

    @GetMapping("/itemCat")
    Result findAll();

    @GetMapping("/itemCat/parent/{id}")
    Result findByParentId(@PathVariable("id") Long id);

    @GetMapping("/itemCat/{pageNo}/{pageSize}")
    PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

    @PostMapping("/itemCat/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbItemCat itemCat, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


    @PostMapping("/itemCat")
    Result saveItemCat(@RequestBody TbItemCat itemCat);

    @PutMapping("/itemCat")
    Result updateItemCat(@RequestBody TbItemCat itemCat);

    @DeleteMapping("/itemCat")
    Result deleteItemCat(@RequestParam("ids") Long[] ids);

    @DeleteMapping("/itemCat/{id}")
    Result deleteOneItemCat(@PathVariable("id") Long id);

    @GetMapping("/itemCat/{id}")
    Result findById(@PathVariable("id") Long id);
}
