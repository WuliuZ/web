package com.itheima.controller.controller;

import com.itheima.Pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//测试请求参数接收
@RestController
public class RequestController {
/*//    原始方式
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
//   获取请求参数
    String name= request.getParameter("name");
    String ageStr =request.getParameter("age");

    int age=Integer.parseInt(ageStr);
    System.out.println(name+"："+age);
    return "ok";
    }*/
//    springboot新方法，传参与形参一致即可
    @RequestMapping("/simpleParam")
    public String simpleParam(String name,String age){
        System.out.println(name+"："+age);
        return "ok";
    }
//     简单实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "ok";
    }
//    复杂实体参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "ok";
    }
//数组参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }
//    集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok";
    }
//    日期参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "ok";
    }
//    json参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }
    //    单个路径参数
    @RequestMapping("/path/{id}")
    public String pathParam1(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }
    //    多个路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+":"+name);
        return "ok";
    }
}
