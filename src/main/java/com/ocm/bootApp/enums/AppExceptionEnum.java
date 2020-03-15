package com.ocm.bootApp.enums;

public enum AppExceptionEnum {
    UNKONWN_ERROR(-1,"unkonwn error"),
    SUCCESS(0,"SUCCESS"),
    LOW_M(1001,"红包太小了"),
    OK_M(1002,"还可以")
    ;

    private Integer code;
    private String  msg;
    AppExceptionEnum(Integer code,String msg){
        this.code = code ;
        this.msg = msg ;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
