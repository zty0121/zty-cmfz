package com.zty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zty.mapper")
public class ZtyCmfzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtyCmfzApplication.class, args);
    }

}

