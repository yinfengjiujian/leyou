package com.leyou.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Title: com.leyou.upload.config</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/21 22:00
 * Description: No Description
 */
@ConfigurationProperties(prefix = "ly.upload")
@Data
@Component
public class UploadProperties {
    private String baseUrl;
    private List<String> allowTypes;
}
