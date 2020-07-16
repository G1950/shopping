package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbSeller;
import com.gm.service.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SellerController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("")
    public Result findAllSeller() {
        return sellerService.findAll();
    }

    @PostMapping("")
    public Result saveSeller(@RequestBody TbSeller seller) {
        return sellerService.saveSeller(seller);
    }

    @PutMapping("")
    public Result updateSeller(@RequestBody TbSeller seller) {
        return sellerService.updateSeller(seller);
    }

    @DeleteMapping("")
    public Result deleteSeller(@RequestParam("ids") String[] ids) {
        return sellerService.deleteSeller(ids);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneSeller(@PathVariable("id") String id) {
        return sellerService.deleteOneSeller(id);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageSeller(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return sellerService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageSeller(@RequestBody TbSeller seller, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return sellerService.findPage(seller, pageNo, pageSize);
    }
}
