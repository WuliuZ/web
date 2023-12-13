package com.itheima.Service.impl;

import com.itheima.Mapper.DeptMapper;
import com.itheima.Pojo.Dept;
import com.itheima.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }
}
