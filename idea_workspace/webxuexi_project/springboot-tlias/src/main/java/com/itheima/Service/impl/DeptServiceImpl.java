package com.itheima.Service.impl;

import com.itheima.Mapper.DeptMapper;
import com.itheima.Pojo.Dept;
import com.itheima.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept queryById(Integer id) {
        Dept dept = deptMapper.queryById(id);
        return dept;
    }

    @Override
    public void modifyById(Dept dept) {
        deptMapper.modifyById(dept);
    }
}
