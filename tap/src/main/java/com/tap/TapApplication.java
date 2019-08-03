package com.tap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.tap.rest.StudentRestController;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@ComponentScan(basePackageClasses = StudentRestController.class)
@ComponentScan({"com.tap.dao"})
public class TapApplication {

	public static void main(String[] args) {
		SpringApplication.run(TapApplication.class, args);
	}
}
