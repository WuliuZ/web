package com.seckill.seckillsystem.Service;


import com.seckill.seckillsystem.Pojo.Employee;

public interface EmployeeService {
    String loginService(String username,String password);
    String registerService(Employee employee);
}
