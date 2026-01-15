package com.example.kafka_consumer_demo.consumer;

import com.example.kafka_consumer_demo.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    private static final Logger logger = LoggerFactory.getLogger(OrderEventConsumer.class);

    @KafkaListener(topics = "${app.kafka.topics.orders:order-events}", groupId = "${spring.kafka.consumer.group-id:order-service}", containerFactory = "kafkaListenerContainerFactory")
    public void handleOrder(OrderEvent orderEvent){
        logger.info("Received Order: {}", orderEvent);
    }
}
