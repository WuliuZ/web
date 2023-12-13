package com.itheima.Controller;

import com.itheima.Pojo.Dept;
import com.itheima.Pojo.Result;
import com.itheima.Service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
//private static Logger log= LoggerFactory.getLogger(DeptController.class);
//    记录日志Slf4j
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)指定请求方式为get
   @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
    log.info("查询全部部分数据");//记录日志


//        调用Service接口的方法进行查询
    List<Dept> deptList = deptService.list();


    return Result.success(deptList);
 }
}
