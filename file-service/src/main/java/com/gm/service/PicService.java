package com.gm.service;

import com.gm.common.Result;
import org.springframework.web.multipart.MultipartFile;

public interface PicService {

    Result uploadPic(MultipartFile file);
}
