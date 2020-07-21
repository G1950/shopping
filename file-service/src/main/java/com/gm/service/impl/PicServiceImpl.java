package com.gm.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.gm.common.Result;
import com.gm.common.ResultEnum;
import com.gm.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName PicServiceImpl
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/15/015 19:15
 * @Version 1.0
 **/
@Service
public class PicServiceImpl implements PicService {
    @Resource
    private FastFileStorageClient fastFileStorageClient;

    @Value("${base.file.url}")
    private String baseUrl;

    @Override
    public Result uploadPic(MultipartFile file) {
        try {
            //1、取文件名
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null)
                return Result.build(ResultEnum.EXCEPTION);
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            extName = extName.toLowerCase();
            if (!(extName.equals("png") || extName.equals("jpg") || extName.equals("jpeg")))
                return Result.build(ResultEnum.UPLOAD_IMG_WARN);
            //2、执行上传处理
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), extName, null);
            System.out.println("全路径: " + storePath.getFullPath());
            System.out.println("路径: " + storePath.getPath());
            return Result.build(ResultEnum.UPLOAD_IMG_SUCCESS, baseUrl + storePath.getFullPath());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.UPLOAD_IMG_FAIL);
        }
    }
}
