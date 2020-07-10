package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.BrandFeignClient;
import com.gm.pojo.TbBrand;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName BrandController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class BrandController {
    private final BrandFeignClient brandFeignClient;

    public BrandController(BrandFeignClient brandFeignClient) {

        this.brandFeignClient = brandFeignClient;
    }

    @GetMapping("/brand")
    public Result findAll() {
        return brandFeignClient.findAll();
    }

    @GetMapping("/brand/{pageNo}/{pageSize}")
    public PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return brandFeignClient.findPage(pageNo, pageSize);
    }

    @PostMapping("/brand/search/{pageNo}/{pageSize}")
    public Result findPage(@RequestBody TbBrand brand, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        return brandFeignClient.searchPage(brand, pageNo, pageSize);
    }

    @PostMapping("/brand")
    public Result saveBrand(@RequestBody TbBrand brand) {
        return brandFeignClient.saveBrand(brand);
    }

    @PutMapping("/brand")
    public Result updateBrand(@RequestBody TbBrand brand) {
        return brandFeignClient.updateBrand(brand);
    }

    @DeleteMapping("/brand")
    public Result deleteBrand(Long[] ids) {
        return brandFeignClient.deleteBrand(ids);
    }


}
