package fr.chouxbeauregard.topic;

import fr.chouxbeauregard.config.JmsConfig;

import javax.jms.*;

public class StatsSubscriber {
    public static void main(String[] args) throws Exception {

        Connection connection = JmsConfig.createConnection();
        Session session = JmsConfig.createSession(connection);

        Topic topic = session.createTopic("OrderTopic");
        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(message -> {
            try {
                System.out.println("Stats mises à jour : " +
                        ((ObjectMessage) message).getObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

