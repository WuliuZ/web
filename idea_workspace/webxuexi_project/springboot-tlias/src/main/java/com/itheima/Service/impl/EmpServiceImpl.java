package com.itheima.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.Mapper.EmpMapper;
import com.itheima.Pojo.Emp;
import com.itheima.Pojo.PageBean;
import com.itheima.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empmapper;
    @Override
    public PageBean page(Integer page,Integer pageSize,
                         String name, Short gender,
                         LocalDate begin,
                         LocalDate end) {
//1、设置分页参数
        PageHelper.startPage(page,pageSize);
//2、查询
        List<Emp> empList=empmapper.list(name,gender,begin,end);
        Page<Emp> p=(Page<Emp>) empList;
//        封装pageBean
        PageBean pageBean =new PageBean(p.getTotal(), p.getResult());


        return pageBean;
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empmapper.deleteByIds(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.addEmp(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empmapper.getById(id);
        return emp;
    }

    @Override
    public void modifyById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.modifyById(emp);
    }
}
