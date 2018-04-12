package com.yixin.springboot.config;/**
 * Created by liushuai2 on 2018/4/10.
 */

import org.apache.catalina.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * Package : com.yixin.springboot.config
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月10日 12:52
 */
@Configuration
@ConfigurationProperties("docker")
public class ServerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ServerConfig.class);


    private List<String> servers = new ArrayList<>();


    public List<String> getServers(){
        logger.info("获取serverConfig信息 {}", servers);
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public static void main(String[] args) throws Exception{
        String paramString2 = "123456";




    }

}
