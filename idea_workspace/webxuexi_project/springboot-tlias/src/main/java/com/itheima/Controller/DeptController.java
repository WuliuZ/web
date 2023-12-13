package com.itheima.Controller;

import com.itheima.Pojo.Dept;
import com.itheima.Pojo.Result;
import com.itheima.Service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
//private static Logger log= LoggerFactory.getLogger(DeptController.class);
//    记录日志Slf4j
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)指定请求方式为get
   @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
    log.info("查询全部部分数据");//记录日志


//        调用Service接口的方法进行查询
    List<Dept> deptList = deptService.list();


    return Result.success(deptList);
 }
  @DeleteMapping("/depts/{id}")
 public Result delete(@PathVariable Integer id){
     log.info("根据id删除部门：{}",id);
     deptService.delete(id);
     return Result.success();
 }

 @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
     log.info("根据name新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
 }
}
