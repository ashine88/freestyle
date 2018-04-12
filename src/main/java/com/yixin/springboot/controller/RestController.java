package com.yixin.springboot.controller;/**
 * Created by liushuai2 on 2018/4/9.
 */

import ch.qos.logback.core.db.DataSourceConnectionSource;
import com.yixin.springboot.config.ServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package : com.yixin.springboot.controller
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月09日 18:45
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private static Logger logger = LoggerFactory.getLogger(RestController.class);
    @Autowired
    ServerConfig serverConfig;
    @RequestMapping("/")
    public  String get(){
        serverConfig.getServers();

        logger.info("start.....................");
        return "hello world";
    }

    public static void main(String[] args) {

    }
}
