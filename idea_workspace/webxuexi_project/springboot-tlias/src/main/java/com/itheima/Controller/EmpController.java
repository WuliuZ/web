package com.itheima.Controller;

import com.itheima.Pojo.PageBean;
import com.itheima.Pojo.Result;
import com.itheima.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
@GetMapping("/emps")
    public Result page(Integer page,Integer pageSize){
    if(page == null){
        page=1;
    }
    if(pageSize == null){
        pageSize=10;
    }
    log.info("分页查询：{}，{}",page,pageSize);
    PageBean pageBean=empService.page(page,pageSize);
    return Result.success(pageBean);
}

}
