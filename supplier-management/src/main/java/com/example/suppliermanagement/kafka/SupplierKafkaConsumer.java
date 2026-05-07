package com.example.suppliermanagement.kafka;

import com.example.suppliermanagement.event.SupplierEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SupplierKafkaConsumer {

    @KafkaListener(
            topics = "supplier-topic",
            groupId = "supplier-group"
    )
    public void consume(SupplierEvent event) {

        System.out.println("========== EVENT RECEIVED ==========");
        System.out.println("Event Type: " + event.getEventType());
        System.out.println("Supplier ID: " + event.getSupplierId());
        System.out.println("Message: " + event.getMessage());
    }
}