package com.cos.graph_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class GraphTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphTestApplication.class, args);
	}

}
