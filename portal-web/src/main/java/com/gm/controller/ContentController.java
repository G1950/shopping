package com.gm.controller;

import com.gm.common.PageResult;
import com.gm.common.Result;
import com.gm.feign.ContentFeignClient;
import com.gm.pojo.TbContent;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName ContentController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/content")
public class ContentController{
private final ContentFeignClient contentFeignClient;

public ContentController(ContentFeignClient contentFeignClient) {
    
        this.contentFeignClient = contentFeignClient;
        }

@GetMapping("")
public Result findAll() {
        return contentFeignClient.findAll();
        }

@GetMapping("/{pageNo}/{pageSize}")
public PageResult findPage(@PathVariable("pageNo")Integer pageNo, @PathVariable("pageSize")Integer pageSize){
        return contentFeignClient.findPage(pageNo,pageSize);
        }

@PostMapping("/search/{pageNo}/{pageSize}")
public Result findPage(@RequestBody TbContent content,@PathVariable("pageNo")Integer pageNo,@PathVariable("pageSize")Integer pageSize){
        return contentFeignClient.searchPage(content,pageNo,pageSize);
        }

@PostMapping("")
public Result saveContent(@RequestBody TbContent content) {
        return contentFeignClient.saveContent(content);
        }

@PutMapping("")
public Result updateContent(@RequestBody TbContent content) {
        return contentFeignClient.updateContent(content);
        }
@DeleteMapping("")
public Result deleteContent(Long [] ids) {
        return contentFeignClient.deleteContent(ids);
        }
 @DeleteMapping("/{id}")
    public Result deleteOneContent(@PathVariable("id") Long id) {
        return contentFeignClient.deleteOneContent(id);
    }

}
