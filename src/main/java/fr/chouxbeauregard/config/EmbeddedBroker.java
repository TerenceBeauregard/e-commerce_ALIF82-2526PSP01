package fr.chouxbeauregard.config;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import java.net.URI;

public class EmbeddedBroker {

    private static BrokerService broker;

    public static void start() throws Exception {
        broker = BrokerFactory.createBroker(
                new URI("broker:(tcp://localhost:61616)")
        );
        broker.start();
        System.out.println("Broker embarqué démarré.");
    }

    public static void stop() throws Exception {
        if (broker != null) {
            broker.stop();
            System.out.println("Broker arrêté.");
        }
    }
}

