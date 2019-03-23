package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: com.leyou.upload.service</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/21 17:35
 * Description: No Description
 */
@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    //分布式FastDFS文件上传对象
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private UploadProperties uploadProperties;

    public String uploadImage(MultipartFile file) {
        try {
            //校验上传文件的类型
            String fileType = file.getContentType();
            //文件类型不对，不允许上传
            if (!uploadProperties.getAllowTypes().contains(fileType)) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //校验文件的内容
            BufferedImage image  = ImageIO.read(file.getInputStream());
            if (null == image) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //上传文件
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            //返回路径
            log.info(uploadProperties.getBaseUrl() + storePath.getFullPath());
            return uploadProperties.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            //上传文件失败
            log.error("[文件上传] 上传文件失败!",e);
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
    }
}
