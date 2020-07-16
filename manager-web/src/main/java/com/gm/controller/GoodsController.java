package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.GoodsFeignClient;
import com.gm.pojo.Goods;
import com.gm.pojo.TbGoods;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class GoodsController {
    private final GoodsFeignClient goodsFeignClient;

    public GoodsController(GoodsFeignClient goodsFeignClient) {

        this.goodsFeignClient = goodsFeignClient;
    }

    @GetMapping("/goods")
    public Result findAll() {
        return goodsFeignClient.findAll();
    }

    @GetMapping("/goods/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return goodsFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/goods/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbGoods goods, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return goodsFeignClient.searchPage(goods, pageNo, pageSize);
    }

    @PostMapping("/goods")
    public Result saveGoods(@RequestBody Goods goods) {
        return goodsFeignClient.saveGoods(goods);
    }

    @PutMapping("/goods")
    public Result updateGoods(@RequestBody Goods goods) {
        return goodsFeignClient.updateGoods(goods);
    }

    @DeleteMapping("/goods")
    public Result deleteGoods(Long[] ids) {
        return goodsFeignClient.deleteGoods(ids);
    }

    @DeleteMapping("/goods/{id}")
    public Result deleteOneGoods(@PathVariable("id") Long id) {
        return goodsFeignClient.deleteOneGoods(id);
    }

}
