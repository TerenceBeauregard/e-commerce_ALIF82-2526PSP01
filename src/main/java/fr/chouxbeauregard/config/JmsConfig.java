package fr.chouxbeauregard.config;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsConfig {

    private static final String BROKER_URL = "tcp://localhost:61616";

    public static Connection createConnection() throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        return connection;
    }

    public static Session createSession(Connection connection) throws Exception {
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }
}

