package com.itheima.mapper;

import com.itheima.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有用户信息
//    @Select("select * from user")
//    public List<User> list();

    public List<User> list();
}
