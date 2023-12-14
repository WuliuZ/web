package com.itheima.Controller;

import com.itheima.Pojo.Emp;
import com.itheima.Pojo.Result;
import com.itheima.Service.EmpService;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登录的用户：{}",emp);
        Emp e = empService.login(emp);

        //登录成功后，生成并下发JWT令牌
        if(e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());


            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

//        登录失败，返回错误信息
        return Result.error("用户名或密码错误！");
    }
}
