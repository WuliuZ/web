//package com.itheima.controller.controller;
//
//import com.itheima.Pojo.Address;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class ResponseController {
//    @RequestMapping("/hello")
//    public String hello(){
//        System.out.println("Hello world");
//        return "Hello World~";
//    }
//    @RequestMapping("/getAddr")
//    public Address getAddr(){
//        Address addr=new Address();
//        addr.setProvince("潼南");
//        addr.setCity("重庆");
//        return addr;
//    }
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr(){
//        List<Address> list=new ArrayList<>();
//        Address addr1=new Address();
//        addr1.setProvince("潼南");
//        addr1.setCity("重庆");
//        Address addr2=new Address();
//        addr2.setProvince("丰都");
//        addr2.setCity("重庆");
//
//        list.add(addr1);
//        list.add(addr2);
//        return list;
//    }
//}
package com.itheima.controller.controller;

import com.itheima.Pojo.Address;
import com.itheima.Pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello world");
        return Result.success("Hello world");
    }
    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr=new Address();
        addr.setProvince("潼南");
        addr.setCity("重庆");
        return Result.success(addr);
    }
    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list=new ArrayList<>();
        Address addr1=new Address();
        addr1.setProvince("潼南");
        addr1.setCity("重庆");
        Address addr2=new Address();
        addr2.setProvince("丰都");
        addr2.setCity("重庆");

        list.add(addr1);
        list.add(addr2);
        return Result.success(list);
    }
}

