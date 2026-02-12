# Projet JMS – Gestion de Commandes E-Commerce

## Objectif

Ce projet implémente une architecture orientée événements utilisant **JMS (Java Message Service)** avec **Apache ActiveMQ (broker embarqué)**.

Il démontre :

- ✔ Le modèle **Point-to-Point** via une **Queue**
- ✔ Le modèle **Publish/Subscribe** via un **Topic**
- ✔ L’envoi d’objets `Serializable` avec `ObjectMessage`
- ✔ Le découplage des services applicatifs

---

# Architecture du Projet


```
fr.chouxbeauregard
│
├── config
│ ├── JmsConfig.java
│ └── EmbeddedBroker.java
│
├── queue
│ ├── OrderProducer.java
│ └── OrderConsumer.java
│
├── topic
│ ├── OrderEventPublisher.java
│ ├── BillingSubscriber.java
│ ├── EmailSubscriber.java
│ ├── StatsSubscriber.java
│ └── ShippingSubscriber.java
│
├── model
│ └── Order.java
│
└── Main.java
```

---

# Fonctionnement global

Le système simule le traitement d’une commande e-commerce selon le flux suivant :

1. `OrderProducer` envoie une commande dans **OrderQueue**
2. `OrderConsumer` consomme la commande (traitement unique)
3. Après traitement, un événement est publié dans **OrderTopic**
4. Plusieurs services abonnés reçoivent simultanément la notification :
    - Facturation
    - Email
    - Statistiques
    - Logistique

---

# Modèle Queue (Point-to-Point)

- Destination : `OrderQueue`
- Un seul consommateur reçoit le message
- Garantit un traitement unique

Utilisé pour :
> Assurer qu’une commande ne soit traitée qu’une seule fois.

---

# Modèle Topic (Publish/Subscribe)

- Destination : `OrderTopic`
- Tous les abonnés actifs reçoivent le message
- Architecture orientée événements

Utilisé pour :
> Notifier plusieurs services indépendants d’un même événement métier.

---

# Lancement du Projet

## Version Broker Embarqué (recommandée)

Le projet utilise un broker ActiveMQ embarqué.  
Aucun serveur externe n’est nécessaire.

### Étape unique :

Lancer la classe :



Main.java


Le programme :

- Démarre le broker embedded
- Démarre les subscribers
- Démarre le consumer
- Envoie la commande via le producer

---

# Exemple de sortie attendue



Broker embarqué démarré.
Service Facturation en attente...
En attente de commande...
Commande envoyée vers la Queue
Commande reçue: Order[ID=CMD-001, Client=Jean Dupont, Montant=250.0]
Evénement publié sur le Topic
Facturation reçoit: ...
Email envoyé pour: ...
Stats mises à jour: ...
Logistique notifiée: ...


---

# Concepts JMS démontrés

- JMS API
- Broker embarqué
- ObjectMessage
- Queue vs Topic
- Découplage des services
- Architecture Event-Driven

---

# Technologies utilisées

- Java
- JMS
- Apache ActiveMQ
- Maven

---

# Conclusion

Ce projet illustre la mise en œuvre combinée des deux modèles fondamentaux de JMS :

- Communication **Point-to-Point**
- Communication **Publish/Subscribe**

Il démontre une architecture distribuée, modulaire et orientée événements adaptée aux systèmes d’entreprise.


Si tu veux, je peux maintenant :

Ajouter un diagramme d’architecture en Mermaid (compatible Markdown GitHub)

Ajouter un diagramme de séquence

Ajouter une section “Améliorations techniques”

Adapter le README pour GitHub professionnel

Dis-moi le niveau de finition que tu veux.