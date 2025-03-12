package com.bank.pe.msbootcoin.consumer;

import com.bank.pe.msbootcoin.entity.BootCoin;
import com.bank.pe.msbootcoin.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @Autowired
    private BootcointService bootcointService;

    @Autowired
    private RedisTemplate<String, BootCoin> redisTemplate;

    @KafkaListener(topics = "bootcamp-Topic", groupId = "group_id")
    public void consume(BootCoin message) {
        logger.info("Creando monedero para el usuario: {}", message.getIdCustomer());

        // Guardar en caché para acceso rápido
        redisTemplate.opsForValue().set("bootcoin:" + message.getIdCustomer(), message);

        // Guardar en BD
        bootcointService.save(message).subscribe();
    }
}
