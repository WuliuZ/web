package com.seckill.seckillsystem.util;




public enum ResultCode {
    SUCCESS(200,"Success"),
    ERROR(400,"Error");

    private Integer code;
    private String  msg;

    ResultCode(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
