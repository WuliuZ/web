package com.seckill.seckillsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seckill.seckillsystem.Pojo")
public class SeckillsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillsystemApplication.class, args);
    }

}
