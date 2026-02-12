package fr.chouxbeauregard.queue;

import fr.chouxbeauregard.config.JmsConfig;
import fr.chouxbeauregard.model.Order;

import javax.jms.*;

public class OrderProducer {

    public static void main(String[] args) throws Exception {

        Connection connection = JmsConfig.createConnection();
        Session session = JmsConfig.createSession(connection);

        Queue queue = session.createQueue("OrderQueue");
        MessageProducer producer = session.createProducer(queue);

        Order order = new Order("CMD-001", "Jean Dupont", 250.0);

        ObjectMessage message = session.createObjectMessage(order);

        producer.send(message);

        System.out.println("Commande envoyée vers la Queue");

        connection.close();
    }
}

