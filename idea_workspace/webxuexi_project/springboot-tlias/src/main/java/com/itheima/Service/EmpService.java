package com.itheima.Service;

import com.itheima.Pojo.Emp;
import com.itheima.Pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {
//    分页查询方法
    PageBean page( Integer page,Integer pageSize,
                   String name, Short gender,
                  LocalDate begin, LocalDate end
                 );
//    批量删除操作
    void deleteByIds(List<Integer> ids);

//    新增员工操作
    void addEmp(Emp emp);
//通过id回显员工信息
    Emp getById(Integer id);
//通过上传的信息，根据id更新员工信息
    void modifyById(Emp emp);
}
