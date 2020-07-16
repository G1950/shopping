package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.ItemCatFeignClient;
import com.gm.pojo.TbItemCat;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName ItemCatController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class ItemCatController {
    private final ItemCatFeignClient itemCatFeignClient;

    public ItemCatController(ItemCatFeignClient itemCatFeignClient) {

        this.itemCatFeignClient = itemCatFeignClient;
    }

    @GetMapping("/itemCat")
    public Result findAll() {
        return itemCatFeignClient.findAll();
    }

    @GetMapping("/itemCat/parent/{id}")
    public Result findByParentId(@PathVariable("id") Long id) {
        return itemCatFeignClient.findByParentId(id);
    }

    @GetMapping("/itemCat/{id}")
    public Result findById(@PathVariable("id") Long id) {
        return itemCatFeignClient.findById(id);
    }

    @GetMapping("/itemCat/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return itemCatFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/itemCat/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbItemCat itemCat, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return itemCatFeignClient.searchPage(itemCat, pageNo, pageSize);
    }

    @PostMapping("/itemCat")
    public Result saveItemCat(@RequestBody TbItemCat itemCat) {
        return itemCatFeignClient.saveItemCat(itemCat);
    }

    @PutMapping("/itemCat")
    public Result updateItemCat(@RequestBody TbItemCat itemCat) {
        return itemCatFeignClient.updateItemCat(itemCat);
    }

    @DeleteMapping("/itemCat")
    public Result deleteItemCat(Long[] ids) {
        return itemCatFeignClient.deleteItemCat(ids);
    }

    @DeleteMapping("/itemCat/{id}")
    public Result deleteOneItemCat(@PathVariable("id") Long id) {
        return itemCatFeignClient.deleteOneItemCat(id);
    }

}
