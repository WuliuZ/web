package com.itheima.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页查询功能的结果封装类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private long total;//总数据量
    private List rows;// 当前页内的数据
}
