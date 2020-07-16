package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.SellerFeignClient;
import com.gm.pojo.TbSeller;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName SellerController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class SellerController {
    private final SellerFeignClient sellerFeignClient;

    public SellerController(SellerFeignClient sellerFeignClient) {

        this.sellerFeignClient = sellerFeignClient;
    }

    @GetMapping("/seller")
    public Result findAll() {
        return sellerFeignClient.findAll();
    }

    @GetMapping("/seller/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return sellerFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/seller/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbSeller seller, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return sellerFeignClient.searchPage(seller, pageNo, pageSize);
    }

    @PostMapping("/seller")
    public Result saveSeller(@RequestBody TbSeller seller) {
        return sellerFeignClient.saveSeller(seller);
    }

    @PutMapping("/seller")
    public Result updateSeller(@RequestBody TbSeller seller) {
        return sellerFeignClient.updateSeller(seller);
    }

    @DeleteMapping("/seller")
    public Result deleteSeller(String[] ids) {
        return sellerFeignClient.deleteSeller(ids);
    }

    @DeleteMapping("/seller/{id}")
    public Result deleteOneSeller(@PathVariable("id") String id) {
        return sellerFeignClient.deleteOneSeller(id);
    }

}
