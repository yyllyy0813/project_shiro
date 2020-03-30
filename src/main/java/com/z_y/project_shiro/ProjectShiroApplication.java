package com.z_y.project_shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.z_y.project_shiro.dao")
public class ProjectShiroApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ProjectShiroApplication.class, args);
    }

}
