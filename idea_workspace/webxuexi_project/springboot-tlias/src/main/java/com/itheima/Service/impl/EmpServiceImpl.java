package com.itheima.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.Mapper.EmpMapper;
import com.itheima.Pojo.Emp;
import com.itheima.Pojo.PageBean;
import com.itheima.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empmapper;
    @Override
    public PageBean page(Integer page,Integer pageSize) {
//1、设置分页参数
        PageHelper.startPage(page,pageSize);
//2、查询
        List<Emp> empList=empmapper.list();
        Page<Emp> p=(Page<Emp>) empList;
//        封装pageBean
        PageBean pageBean =new PageBean(p.getTotal(), p.getResult());


        return pageBean;
    }
}
