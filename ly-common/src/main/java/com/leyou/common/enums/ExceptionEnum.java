package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <p>Title: com.leyou.common.enums</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/20 11:17
 * Description: No Description
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,"价格不能为空！"),
    CATEGORY_NOT_FOUND(404,"没有查询到商品信息！"),
    SPEC_GROUP_NOT_FOUND(404,"商品规格组不存在"),
    SPEC_PARAM_NOT_FOUND(404,"商品规格参数不存在"),
    BRAND_NOT_FOUND(404,"品牌不存在！"),
    SAVE_BRAND_ERROR(500,"新增品牌失败"),
    INVALID_FILE_TYPE(500,"文件类型无效！"),
    UPLOAD_FILE_ERROR(500,"上传文件失败，发生错误！"),
    ;
    private int resultCode;
    private String message;
}
