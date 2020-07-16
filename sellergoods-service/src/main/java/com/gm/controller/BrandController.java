package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbBrand;
import com.gm.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BrandController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/7/007 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("")
    public Result findAllBrand() {
        return brandService.findAll();
    }

    @PostMapping("")
    public Result saveBrand(@RequestBody TbBrand brand) {
        return brandService.saveBrand(brand);
    }

    @PutMapping("")
    public Result updateBrand(@RequestBody TbBrand brand) {
        return brandService.updateBrand(brand);
    }

    @DeleteMapping("")
    public Result deleteBrand(@RequestParam("ids") Long[] ids) {
        return brandService.deleteBrand(ids);
    }

    @DeleteMapping("/{id}")
    public Result deleteOneBrand(@PathVariable("id") Long id) {
        return brandService.deleteOneBrand(id);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public PageResult findPageBrand(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return brandService.findPage(pageNo, pageSize);
    }

    @PostMapping("/search/{pageNo}/{pageSize}")
    public Result searchPageBrand(@RequestBody TbBrand brand, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return brandService.findPage(brand, pageNo, pageSize);
    }

}
