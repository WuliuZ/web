package com.itheima.Service;

import com.itheima.Pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    //查询全部数据
  List<Dept> list();
}
