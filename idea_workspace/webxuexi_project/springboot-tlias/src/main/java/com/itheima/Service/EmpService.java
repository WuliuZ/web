package com.itheima.Service;

import com.itheima.Pojo.PageBean;
import org.springframework.stereotype.Service;


public interface EmpService {
    PageBean page(Integer page,Integer pageSize);
}
