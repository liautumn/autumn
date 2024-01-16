package com.autumn.common.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessageRabbitMQ {

    String queueName = "message.direct.queue.";
    String exchangeName = "direct_message_exchange";

    @Resource
    private ConnectionFactory connectionFactory;

    public void delete(String userId) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        String queueName = this.queueName + userId;
        rabbitAdmin.deleteQueue(queueName);
        rabbitAdmin.deleteExchange(exchangeName);
        //关闭连接
        close();
    }

    public void createMQ(String userId) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        String queueName = this.queueName + userId;
        //创建交换机
        Exchange exchange = new DirectExchange(exchangeName, true, false);
        rabbitAdmin.declareExchange(exchange);
        //新增队列
        rabbitAdmin.declareQueue(new Queue(queueName, true));
        //新增绑定关系
        rabbitAdmin.declareBinding(new Binding(queueName, Binding.DestinationType.QUEUE, exchangeName, userId, null));
        //关闭连接
        close();
    }

    /**
     * 关闭连接
     */
    public void close() {
        try (Connection connection = connectionFactory.createConnection()) {
            try (Channel channel = connection.createChannel(true)) {
                com.rabbitmq.client.Connection connection1 = channel.getConnection();
                connection1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
