package com.itheima.Mapper;

import com.itheima.Pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    员工查询
//@Select("select * from tlias.emp where name like concat('%',#{name},'%') " +
//        "and gender=#{gender} and entrydate between #{begin} and #{} order by update_time desc")
public List<Emp> list(String name, Short gender,
                      LocalDate begin,
                      LocalDate end);

    void deleteByIds(List<Integer> ids);

    void addEmp(Emp emp);
}
