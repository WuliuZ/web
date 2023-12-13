package com.itheima.Controller;

import com.itheima.Pojo.Emp;
import com.itheima.Pojo.PageBean;
import com.itheima.Pojo.Result;
import com.itheima.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/emps")
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(Integer page, Integer pageSize, String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        log.info("分页查询：{}，{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        log.info("批量删除操作，ids：{}",ids);
        empService.deleteByIds(ids);

        return Result.success();
    }
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("新增员工，emp：{}",emp);
        empService.addEmp(emp);

        return Result.success();
    }

}
