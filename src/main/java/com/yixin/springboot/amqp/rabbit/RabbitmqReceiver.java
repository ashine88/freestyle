package com.yixin.springboot.amqp.rabbit;/**
 * Created by liushuai2 on 2018/4/11.
 */

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Rabbitmq 消息接收类
 *
 *
 * Package : com.yixin.springboot.amqp.rabbit
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月11日 23:33
 */
@Component
public class RabbitmqReceiver {
    private static final Logger logger = LoggerFactory.getLogger(RabbitmqReceiver.class);

    @RabbitListener(queues = "yx_test_001_queue", containerFactory = "testContainerFactory")
    public void receive(Message message, Channel channel){
        try {
            String msgBody = new String(message.getBody(), "UTF-8");
            logger.info("接收risk的mq消息msg:{}", msgBody);
        } catch (UnsupportedEncodingException e) {
            logger.error("[rabbitmq]接收消息失败，原因是无法转换为string", e);
        }finally {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            try {
                /**
                 * 不允许重新发送
                 */
                channel.basicNack(deliveryTag, false, false);
                logger.info("[rabbitmq]开始应答");
                logger.info("[rabbitmq]结束应答");
            } catch (IOException e) {
                logger.error("[rabbitmq]应答消息失败", e);
            }
        }

    }

}
