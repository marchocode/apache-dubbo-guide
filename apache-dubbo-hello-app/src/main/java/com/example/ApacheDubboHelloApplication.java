package com.example;

import com.example.pojo.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ApacheDubboHelloApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApacheDubboHelloApplication.class, args);
    }

    @DubboReference
    private IUserService iUserService;

    @Override
    public void run(String... args) throws Exception {
        Response<UserDTO> userDTO = iUserService.queryUserById(1l);
        System.out.println(userDTO);
    }
}