package com.itheima.Mapper;

import com.itheima.Pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /*查询全部部门操作*/
@Select("select * from tlias.dept")
    List<Dept> list();
@Delete("delete from tlias.dept where id=#{id}")
void deleteById(Integer id) ;

@Insert("insert into tlias.dept(name, create_time, update_time) value (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
