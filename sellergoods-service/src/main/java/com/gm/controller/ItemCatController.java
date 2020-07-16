package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbItemCat;
import com.gm.service.ItemCatService;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ItemCatController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    private final ItemCatService itemCatService;

    public ItemCatController(ItemCatService itemCatService) {
        this.itemCatService = itemCatService;
    }

    @GetMapping("")
    public Result findAllItemCat() {
        return itemCatService.findAll();
    }

    @GetMapping("/parent/{id}")
    public Result findItemCatByParentId(@PathVariable("id") Long id) {
        return itemCatService.findByParentId(id);
    }

    @GetMapping("/{id}")
    public Result findItemCatById(@PathVariable("id") Long id) {
        return itemCatService.findById(id);
    }

    @PostMapping("")
    public Result saveItemCat(@RequestBody TbItemCat itemCat) {
        return itemCatService.saveItemCat(itemCat);
    }

    @PutMapping("")
    public Result updateItemCat(@RequestBody TbItemCat itemCat) {
        return itemCatService.updateItemCat(itemCat);
    }

    @DeleteMapping("")
    public Result deleteItemCat(@RequestParam("ids") Long[] ids) {
        return itemCatService.deleteItemCat(ids);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneItemCat(@PathVariable("id") Long id) {
        return itemCatService.deleteOneItemCat(id);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageItemCat(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return itemCatService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageItemCat(@RequestBody TbItemCat itemCat, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return itemCatService.findPage(itemCat, pageNo, pageSize);
    }
}
