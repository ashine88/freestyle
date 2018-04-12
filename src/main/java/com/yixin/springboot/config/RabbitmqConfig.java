package com.yixin.springboot.config;/**
 * Created by liushuai2 on 2018/4/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Package : com.yixin.springboot.config
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月11日 23:00
 */
@Configuration
public class RabbitmqConfig {
    public static final Logger logger = LoggerFactory.getLogger(RabbitmqConfig.class);
    /**
     * risk rabbitmq connectionFactory
     * @param addresses
     * @param username
     * @param password
     * @param virtualHost
     * @return
     */
    @Bean(name = "testConnectionFactory")
    @Primary
    public ConnectionFactory riskConnectionFactory(
            @Value("${spring.rabbitmq.test.addresses}")     String addresses,
            @Value("${spring.rabbitmq.test.username}")      String username,
            @Value("${spring.rabbitmq.test.password}")      String password,
            @Value("${spring.rabbitmq.test.virtual-host}")   String virtualHost

    ){
        logger.info("[rabbitmq]初始化connectionFactory，address:{}, username:{}, password:{}, virtual-host:{}",
                addresses, username, password, virtualHost);
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses(addresses);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        return factory;
    }

    @Bean(name = "testContainerFactory")
    public SimpleRabbitListenerContainerFactory testContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("testConnectionFactory") ConnectionFactory connectionFactory
            ){
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(containerFactory, connectionFactory);
        // 这是手动应答方式
        containerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return containerFactory;
    }


    @Bean
    public Queue testQueue(@Value("${spring.rabbitmq.test.queue}") String queue){
        logger.info("[rabbitmq]初始化队列 queue:{}", queue);
        return new Queue(queue);
    }


}
