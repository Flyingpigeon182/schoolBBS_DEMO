package com.example.tree_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/tree_demo/mapper")
public class TreeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeDemoApplication.class, args);
	}
}
