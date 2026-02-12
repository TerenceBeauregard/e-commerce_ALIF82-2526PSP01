package fr.chouxbeauregard.topic;

import fr.chouxbeauregard.config.JmsConfig;

import javax.jms.*;

public class BillingSubscriber {

    public static void main(String[] args) throws Exception {

        Connection connection = JmsConfig.createConnection();
        Session session = JmsConfig.createSession(connection);

        Topic topic = session.createTopic("OrderTopic");

        MessageConsumer consumer = session.createConsumer(topic);

        System.out.println("Service Facturation en attente...");

        consumer.setMessageListener(message -> {
            try {
                System.out.println("Facturation reçoit: " +
                        ((ObjectMessage) message).getObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

