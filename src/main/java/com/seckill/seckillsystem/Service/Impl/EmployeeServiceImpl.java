package com.seckill.seckillsystem.Service.Impl;


import com.seckill.seckillsystem.Mapper.EmployeeMapper;
import com.seckill.seckillsystem.Pojo.Employee;
import com.seckill.seckillsystem.Service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public String loginService(String username, String password) {
        Employee  employee=employeeMapper.findByUsername(username);
        if(employee == null){
            return "用户不存在";
        }else{
            if(password.equals(employee.getPassword())){
                return "SUCCESS";
            }else{
                return "用户密码错误";
            }
        }
    }

    @Override
    public String registerService(Employee employee) {
        String tempUnm=employee.getUsername();
        Employee tempemployee= employeeMapper.findByUsername(tempUnm);

        if(tempemployee!=null){
            return "用户已存在";
        }else {
            employeeMapper.save(employee);
            return "SUCCESS";
        }
    }
}
