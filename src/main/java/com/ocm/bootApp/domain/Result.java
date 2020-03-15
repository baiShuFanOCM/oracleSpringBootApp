package com.ocm.bootApp.domain;
import static javafx.scene.input.KeyCode.T;

/**
 * http请求返回的最终结果
 */

public class Result<T> {
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //泛型返回数据类型
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
