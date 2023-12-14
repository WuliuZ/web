package com.itheima.Controller;

import com.itheima.Pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，参数名：{}", image.getOriginalFilename());
//  调用阿里云的OSS工具类

        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，访问url为：{}", url);
//        返回url
        return Result.success(url);
    }
    //1、上传文件存储在本地
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
//        log.info("文件上传，参数：{}，{}，{}",username,age,image);
//
////        1.1 从image中获取原始上传文件名
//        String originalFilename=image.getOriginalFilename();
////        1.2构建不重复的文件名，uuid通用唯一识别码
//        int index= originalFilename.lastIndexOf(".");//拿到最后一个.的位置
//        String extname = originalFilename.substring(index);//通过最后一个点进行后缀截取
//        String newFileName = UUID.randomUUID().toString()+extname;//将uuid与后缀拼接得到新的文件名
////        1.3 将文件存储在本地磁盘
//        image.transferTo(new File("D:\\image\\"+newFileName));
//
//        return Result.success();
//    }
}

