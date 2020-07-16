package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.Goods;
import com.gm.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("")
    public Result findAllGoods() {
        return goodsService.findAll();
    }

    @PostMapping("")
    public Result saveGoods(@RequestBody Goods goods) {
        return goodsService.saveGoods(goods);
    }

    @PutMapping("")
    public Result updateGoods(@RequestBody Goods goods) {
        return goodsService.updateGoods(goods);
    }

    @DeleteMapping("")
    public Result deleteGoods(@RequestParam("ids") Long[] ids) {
        return goodsService.deleteGoods(ids);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneGoods(@PathVariable("id") Long id) {
        return goodsService.deleteOneGoods(id);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageGoods(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return goodsService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageGoods(@RequestBody Goods goods, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return goodsService.findPage(goods, pageNo, pageSize);
    }
}
