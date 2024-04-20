package com.seckill.seckillsystem.util;

public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Object object){
        Result result=new Result();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMsg(ResultCode.ERROR.getMsg());
        result.setData(object);
        return result;


    }
}
//db.getCollection("employee").drop();
//        db.createCollection("employee");
//
//// ----------------------------
//// Documents of user
//// ----------------------------
//        db.getCollection("employee").insert([ {
//        _id: ObjectId("634617c49d110f9df6014f83"),
//        username: "bcn",
//        password: "123"
//        } ]);
//     db.getCollection("employee").insert([ {
//        _id: ObjectId("634618219d110f9df6014f85"),
//        username: "alg",
//        password: 123
//        } ]);
//        db.getCollection("employee").insert([ {
//        _id: ObjectId("63462e5c39561e5497cfd4bf"),
//        username: "aaa",
//        password: "123",
//        _class: "com.seckill.seckillsystem.Pojo.Employee"
//
//        } ]);
