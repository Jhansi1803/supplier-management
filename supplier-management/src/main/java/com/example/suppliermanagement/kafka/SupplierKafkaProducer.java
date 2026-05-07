package com.example.suppliermanagement.kafka;

import com.example.suppliermanagement.event.SupplierEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierKafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "supplier-topic";

    public void publishEvent(SupplierEvent event) {

    try {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Kafka event published successfully");
    } catch (Exception e) {
        System.out.println("Kafka is not running currently");
    }
}
}