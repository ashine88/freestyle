package com.yixin.springboot.config;/**
 * Created by liushuai2 on 2018/4/10.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Package : com.yixin.springboot.config
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月10日 23:01
 */
@Configuration
public class ApplicationConfig {

    @Value("${docker.containerId}")
    private String containerId;

    @Value("${docker.container.desc}")
    private String containerDesc;


    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getContainerDesc() {
        return containerDesc;
    }

    public void setContainerDesc(String containerDesc) {
        this.containerDesc = containerDesc;
    }
}
