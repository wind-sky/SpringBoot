package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用来标注这是一个Spring Boot 应用
@SpringBootApplication
@RestController //标注这个程序还是一个控制器
public class DemoApplication {

    @RequestMapping("/")
    String home()
    {
        return "hello";
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

//https://github.com/chenfromsz/spring-boot-hello.git

