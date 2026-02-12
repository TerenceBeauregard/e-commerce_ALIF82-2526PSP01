package fr.chouxbeauregard;

import fr.chouxbeauregard.config.EmbeddedBroker;
import fr.chouxbeauregard.queue.OrderConsumer;
import fr.chouxbeauregard.queue.OrderProducer;
import fr.chouxbeauregard.topic.*;


public class Main {

    public static void main(String[] args) throws Exception {

        // 1️⃣ Démarrer le broker embarqué
        EmbeddedBroker.start();

        // 2️⃣ Lancer les subscribers (Topic)
        new Thread(() -> {
            try { BillingSubscriber.main(null); } catch (Exception e) { }
        }).start();

        new Thread(() -> {
            try { EmailSubscriber.main(null); } catch (Exception e) { }
        }).start();

        new Thread(() -> {
            try { StatsSubscriber.main(null); } catch (Exception e) { }
        }).start();

        new Thread(() -> {
            try { ShippingSubscriber.main(null); } catch (Exception e) { }
        }).start();

        Thread.sleep(2000);

        // 3️⃣ Lancer le consumer (Queue)
        new Thread(() -> {
            try { OrderConsumer.main(null); } catch (Exception e) { }
        }).start();

        Thread.sleep(2000);

        // 4️⃣ Lancer le producer
        OrderProducer.main(null);

    }
}

