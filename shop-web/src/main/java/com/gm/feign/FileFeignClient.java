package com.gm.feign;

import com.gm.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("FILE-SERVICE")
public interface FileFeignClient {

    @PostMapping(value = "/upload/pic", consumes = "multipart/form-data")
    Result uploadPic(@RequestPart(value = "file") MultipartFile file);
}
