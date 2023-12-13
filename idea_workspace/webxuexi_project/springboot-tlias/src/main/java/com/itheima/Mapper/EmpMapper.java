package com.itheima.Mapper;

import com.itheima.Pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

//    员工学习查询
@Select("select * from tlias.emp")
public List<Emp> list();
}
