package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class SpringbootTliasApplicationTests {

    @Test
    void contextLoads() {
    }

//    测试JWT令牌
@Test
    public void testSetJWT(){
        Map<String, Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"itheima")//签名算法ES256
                .setClaims(claims)//自定义内容，处于中间
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();//设置有效期限
        System.out.println(jwt);
    }

    @Test
    public void testJieXiJWT(){
         Claims claims = Jwts.parser()
                .setSigningKey("itheima")//解析的秘钥，与设置时相同
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwMjU2MzM0NX0.Whse9ZoUc8vH2_7875Ck30a3-PklEhdTVHaJ8nn1RZ4")
                .getBody() ;
         System.out.println(claims);

    }

}
