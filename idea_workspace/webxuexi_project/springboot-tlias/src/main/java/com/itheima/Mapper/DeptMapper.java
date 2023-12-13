package com.itheima.Mapper;

import com.itheima.Pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /*查询全部部门操作*/
@Select("select * from tlias.dept")
    List<Dept> list();
//  按id删除部门
@Delete("delete from tlias.dept where id=#{id}")
void deleteById(Integer id) ;

//  新增部门信息
@Insert("insert into tlias.dept(name, create_time, update_time) " +
        "value (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

//  按id查询部门信息
@Select("select * from tlias.dept where id=#{id}")
    Dept queryById(Integer id);

//  按id修改部门信息
@Update("update tlias.dept set name=#{name} where id=#{id}")
    void modifyById(Dept dept);
}

