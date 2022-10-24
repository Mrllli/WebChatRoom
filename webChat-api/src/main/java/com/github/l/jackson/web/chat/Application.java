package com.github.l.jackson.web.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication(scanBasePackages = "com.github.l.jackson")
@MapperScan("com.github.l.jackson.web.chat.dao")
@ServletComponentScan
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
