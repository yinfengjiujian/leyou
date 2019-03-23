package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * <p>Title: com.leyou.common.vo</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/20 11:31
 * Description: No Description
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum) {

        this.status = exceptionEnum.getResultCode();
        this.message = exceptionEnum.getMessage();
        this.timestamp = System.currentTimeMillis();
    }
}
