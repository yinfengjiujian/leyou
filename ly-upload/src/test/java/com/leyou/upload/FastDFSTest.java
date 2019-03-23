package com.leyou.upload;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * <p>Title: com.leyou.upload</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/21 21:23
 * Description: No Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSTest {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("E:/timg.jpg");

        StorePath storePath = this.fastFileStorageClient.uploadFile(
                new FileInputStream(file),file.length(),"jpg",null);

        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException{
        File file = new File("E:/timg.jpg");

        StorePath storePath = this.fastFileStorageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file),file.length(),"jpg",null);

        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());

        String path = this.thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(path);
    }

}
