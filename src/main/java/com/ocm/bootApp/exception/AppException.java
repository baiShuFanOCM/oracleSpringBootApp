package com.ocm.bootApp.exception;

import com.ocm.bootApp.enums.AppExceptionEnum;

/**
 * 构建项目异常类
 */

public class AppException  extends RuntimeException{
    private Integer code;

    /**
     * @param code
     * @param message
     * 没有用枚举之前
     * public AppException(Integer code,String message){
     *         super(message);
     *         this.code = code;
     * }
     */

    public AppException(AppExceptionEnum appExceptionEnum){
        super(appExceptionEnum.getMsg());
        this.code = appExceptionEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }


}
