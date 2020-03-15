package com.ocm.bootApp.handle;


import com.ocm.bootApp.domain.Result;
import com.ocm.bootApp.exception.AppException;
import com.ocm.bootApp.utils.ResultUtil;
import com.sun.javafx.util.Logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获处理
 */
@ControllerAdvice
public class ExceptionHandle {

    private final  static Logger  logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exHandle(Exception e){
        if(e instanceof AppException){
            AppException appException = (AppException)e;
            return ResultUtil.error(appException.getCode(),appException.getMessage());
        }else{
            logger.error("[sys execption] {}",e);
            return ResultUtil.error(100,"unkonwn error");
        }



    }
}
