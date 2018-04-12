package com.yixin.springboot;

import com.yixin.springboot.component.ConfigComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class FreestyleApplication {
	public static final Logger logger = LoggerFactory.getLogger(FreestyleApplication.class);

	@Autowired
	private ConfigComponent configComponent;

	public static void main(String[] args) {
		SpringApplication.run(FreestyleApplication.class, args);
	}

	@PostConstruct
	public void init(){
		configComponent.printApplicationConfig();
	}
}
