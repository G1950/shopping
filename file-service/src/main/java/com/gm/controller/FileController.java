package com.gm.controller;

import com.gm.common.Result;
import com.gm.service.PicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/15/015 17:34
 * @Version 1.0
 **/

@RestController
@RequestMapping("/upload")
public class FileController {
    private final PicService picService;

    public FileController(PicService picService) {
        this.picService = picService;
    }


    @PostMapping("/pic")
    public Result uploadPic(@RequestPart("file") MultipartFile file) {
        return picService.uploadPic(file);
    }
}
