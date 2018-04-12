package com.yixin.springboot.config;/**
 * Created by liushuai2 on 2018/4/10.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Package : com.yixin.springboot.config
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月10日 16:06
 */
@Configuration
public class DatasourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.data-password}")
    private String password;
    @Value("${spring.datasource.data-username}")
    private String userName;

    @Value("${spring.datasource.url}")
    private String connectionUrl;



    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
}
