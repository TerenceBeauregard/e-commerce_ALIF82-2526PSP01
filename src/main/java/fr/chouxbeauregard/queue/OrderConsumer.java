package fr.chouxbeauregard.queue;

import fr.chouxbeauregard.config.JmsConfig;
import fr.chouxbeauregard.model.Order;
import fr.chouxbeauregard.topic.OrderEventPublisher;

import javax.jms.*;

public class OrderConsumer {

    public static void main(String[] args) throws Exception {

        Connection connection = JmsConfig.createConnection();
        Session session = JmsConfig.createSession(connection);

        Queue queue = session.createQueue("OrderQueue");
        MessageConsumer consumer = session.createConsumer(queue);

        System.out.println("En attente de commande...");

        Message message = consumer.receive();

        if (message instanceof ObjectMessage) {
            Order order = (Order) ((ObjectMessage) message).getObject();
            System.out.println("Commande reçue: " + order);

            // Publication sur Topic après traitement
            OrderEventPublisher.publish(order);
        }

        connection.close();
    }
}
