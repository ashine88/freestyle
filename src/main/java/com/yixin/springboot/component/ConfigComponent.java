package com.yixin.springboot.component;/**
 * Created by liushuai2 on 2018/4/10.
 */

import com.yixin.springboot.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Package : com.yixin.springboot.component
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月10日 23:07
 */
@Component
public class ConfigComponent {
    public static final Logger logger = LoggerFactory.getLogger(ConfigComponent.class);
    @Autowired
    ApplicationConfig applicationConfig;

    public void printApplicationConfig(){
        logger.info("start to pring ApplicationConfig");
        logger.info("containerId:{}, containerDesc:{}", applicationConfig.getContainerId(),
                applicationConfig.getContainerDesc());

    }




}
