package com.seckill.seckillsystem.Controller;

import com.seckill.seckillsystem.Pojo.Employee;
import com.seckill.seckillsystem.Service.Impl.EmployeeServiceImpl;
import com.seckill.seckillsystem.util.Result;
import com.seckill.seckillsystem.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping("/login")
    public Result login(@RequestParam String username,@RequestParam String password){
        String msg=employeeServiceImpl.loginService(username, password);
        if("SUCCESS".equals(msg)){
            return ResultUtil.success("登录成功");
        }else {
            return ResultUtil.error(msg);
        }
    }

    @RequestMapping("/register")
    public Result register(@RequestBody Employee employee){
        String msg=employeeServiceImpl.registerService(employee);
        if ("SUCCESS".equals(msg)) {
            return ResultUtil.success("注册成功");
        }else {
            return ResultUtil.error(msg);
        }
    }
}
