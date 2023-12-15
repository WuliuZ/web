package com.itheima.Exception;

import com.itheima.Pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exception(Exception ex){
        ex.printStackTrace();
        return Result.error("操作出错，请联系管理员");



    }
}
