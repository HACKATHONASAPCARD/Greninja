package com.hackathon.mq;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MqConfig {

	public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // Substitua pelo seu host RabbitMQ
        factory.setPort(5672);        // Substitua pela sua porta RabbitMQ

        // Se necessário, configure outras propriedades como usuário, senha, etc.

        return factory.newConnection();
    }
}
