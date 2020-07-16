package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSeller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("SELLERGOODS-SERVICE")
public interface SellerFeignClient {

    @GetMapping("/seller")
    Result findAll();

    @GetMapping("/seller/{pageNo}/{pageSize}")
    PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

    @PostMapping("/seller/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbSeller seller, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


    @PostMapping("/seller")
    Result saveSeller(@RequestBody TbSeller seller);

    @PutMapping("/seller")
    Result updateSeller(@RequestBody TbSeller seller);

    @DeleteMapping("/seller")
    Result deleteSeller(@RequestParam("ids") String[] ids);

    @DeleteMapping("/seller/{id}")
    Result deleteOneSeller(@PathVariable("id") String id);
}
