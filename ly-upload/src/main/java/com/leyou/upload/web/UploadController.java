package com.leyou.upload.web;

import com.leyou.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title: com.leyou.upload.web</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/21 17:29
 * Description: No Description
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 上传图片微服务
     * @param file
     * @return
     */
    @PostMapping(value = "/image")
    public ResponseEntity<String> uploadImage(@RequestParam(value = "file") MultipartFile file){
        return ResponseEntity.ok(uploadService.uploadImage(file));
    }
}
