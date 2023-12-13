package com.itheima.Mapper;

import com.itheima.Pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /*查询全部部门操作*/
@Select("select * from tlias.dept")
    List<Dept> list();
}
