package com.naresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJpaExample1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaExample1Application.class, args);
	}

}
