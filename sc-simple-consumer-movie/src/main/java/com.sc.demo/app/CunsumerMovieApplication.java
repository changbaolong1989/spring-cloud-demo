package com.sc.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class CunsumerMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(CunsumerMovieApplication.class, args);
    }

}
