package com.itheima.service.impl;

import com.itheima.Pojo.Emp;
import com.itheima.dao.EmpDao;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

public class EmpServiceB implements EmpService {
// private EmpDao empDao= new EmpDaoA();
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        //1、调用dao,获取数据
        List<Emp> empList=empDao.listEmp();


        //2、对数据进行转换处理
        empList.stream().forEach(emp -> {
            //处理 gender 1:男,2:女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男士");
            }else if("2".equals(gender)){
                emp.setGender("女士");
            }
//             1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setGender("讲师");
            }else if("2".equals(job)){
                emp.setGender("班主任");
            }else if("3".equals(job)){
                emp.setGender("就业指导");
            }
        });
        return empList;
    }
}
