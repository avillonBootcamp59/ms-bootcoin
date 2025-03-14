package com.bank.pe.msbootcoin.producer;

import com.bank.pe.msbootcoin.entity.BootCoin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    private final KafkaTemplate<String, BootCoin> kafkaTemplate;

    public KafkaStringProducer(KafkaTemplate<String, BootCoin> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BootCoin message) {
        LOGGER.info("Enviando mensaje para customer: {}", message.getIdCustomer());
        this.kafkaTemplate.send("bootcamp-Topic", message);
    }
}
