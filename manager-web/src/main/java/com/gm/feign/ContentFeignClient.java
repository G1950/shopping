package com.gm.feign;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.pojo.TbContent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("CONTENT-SERVICE")
public interface ContentFeignClient{

@GetMapping("/content")
Result findAll();

@GetMapping("/content/{pageNo}/{pageSize}")
PageResult findPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);

@PostMapping("/content/search/{pageNo}/{pageSize}")
    Result searchPage(@RequestBody TbContent content, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize);


@PostMapping("/content")
    Result saveContent(@RequestBody TbContent content);

@PutMapping("/content")
    Result updateContent(@RequestBody TbContent content);

@DeleteMapping("/content")
    Result deleteContent(@RequestParam("ids") Long[]ids);
@DeleteMapping("/content/{id}")
    Result deleteOneContent(@PathVariable("id") Long id);
        }
