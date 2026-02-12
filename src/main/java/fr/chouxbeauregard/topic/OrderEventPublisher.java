package fr.chouxbeauregard.topic;

import fr.chouxbeauregard.config.JmsConfig;
import fr.chouxbeauregard.model.Order;

import javax.jms.*;

public class OrderEventPublisher {

    public static void publish(Order order) throws Exception {

        Connection connection = JmsConfig.createConnection();
        Session session = JmsConfig.createSession(connection);

        Topic topic = session.createTopic("OrderTopic");

        MessageProducer producer = session.createProducer(topic);
        ObjectMessage message = session.createObjectMessage(order);

        producer.send(message);

        System.out.println("Evénement publié sur le Topic");

        connection.close();
    }
}

