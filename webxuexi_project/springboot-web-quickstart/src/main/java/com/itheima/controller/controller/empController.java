package com.itheima.controller.controller;

import com.itheima.Pojo.Emp;
import com.itheima.Pojo.Result;
import com.itheima.dao.EmpDao;
import com.itheima.dao.impl.EmpDaoA;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceA;
import com.itheima.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class empController {
    private EmpService empService= new EmpServiceA();
    @RequestMapping("/listEmp")
    public Result list(){
    //1、调用service，获取数据
        List<Emp> empList=empService.listEmp();
    //响应数据
        return Result.success(empList);
    }
}

//    @RequestMapping("/listEmp")
//    public Result list(){
//        //1、解析Xml文件
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//        //2、对数据进行处理转换
//        empList.stream().forEach(emp -> {
//            //处理 gender 1:男,2:女
//            String gender = emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            }else if("2".equals(gender)){
//                emp.setGender("女");
//            }
////             1: 讲师, 2: 班主任 , 3: 就业指导
//            String job = emp.getJob();
//            if("1".equals(job)){
//                emp.setGender("讲师");
//            }else if("2".equals(job)){
//                emp.setGender("班主任");
//            }else if("3".equals(job)){
//                emp.setGender("就业指导");
//            }
//        });
//        //3、响应数据
//        return Result.success(empList);



