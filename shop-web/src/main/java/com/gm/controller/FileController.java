package com.gm.controller;

import com.gm.common.Result;
import com.gm.feign.FileFeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/15/015 20:45
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class FileController {

    private final FileFeignClient fileFeignClient;

    public FileController(FileFeignClient fileFeignClient) {
        this.fileFeignClient = fileFeignClient;
    }

    @PostMapping("/upload/pic")
    public Result uploadPic(@RequestParam("file") MultipartFile file) {
        return fileFeignClient.uploadPic(file);
    }
}
