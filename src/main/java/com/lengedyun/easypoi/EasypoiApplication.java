package com.lengedyun.easypoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class EasypoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasypoiApplication.class, args);
    }

}
