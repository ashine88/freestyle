package com.yixin.springboot;/**
 * Created by liushuai2 on 2018/4/9.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Package : com.yixin.springboot
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月09日 22:14
 */
//@SpringBootApplication
public class ExitCodeApplication {
    public static final Logger logger = LoggerFactory.getLogger(ExitCodeApplication.class);
    @Bean
    ExitCodeGenerator exitCodeGenerator(){
        // 在jvm停止之前执行
        logger.info("jvm停止前执行该方法");
        return () -> 42;
    }

    public static void main(String[] args) {
        logger.info("测试exitCodeGenerator");
        System.exit(SpringApplication
                .exit(SpringApplication.run(ExitCodeApplication.class, args)));

    }
}
