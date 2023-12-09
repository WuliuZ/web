package com.itheima.dao.impl;

import com.itheima.Pojo.Emp;
import com.itheima.dao.EmpDao;
import com.itheima.utils.XmlParserUtils;

import java.util.List;

public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
