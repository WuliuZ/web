package com.itheima.Mapper;

import com.itheima.Pojo.Dept;
import com.itheima.Pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //    员工查询
//@Select("select * from tlias.emp where name like concat('%',#{name},'%') " +
//
//        "and gender=#{gender} and entrydate between #{begin} and #{} order by update_time desc")
//列表查询
    public List<Emp> list(String name, Short gender,
                          LocalDate begin,
                          LocalDate end);

    //  删除
    void deleteByIds(List<Integer> ids);

    //    新增
    void addEmp(Emp emp);
//    按id查询
    @Select("select * from tlias.emp where id = #{id}")
    Emp getById(Integer id);

 //根据所上传信息更新员工信息
    void modifyById(Emp emp);

//    根据用户名和密码查询该员工
    @Select("select * from tlias.emp where username=#{username} and password = #{password}")
    Emp quaryByUsernameAndPassword(Emp emp);


    /**
     * 按部门删除员工
     * @param dept
     */
    @Delete("delete from tlias.emp where dept_id=#{id}")
    void deleteByDeptId(Integer id);

}
