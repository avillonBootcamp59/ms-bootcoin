package com.bank.pe.msbootcoin.controllers;

import com.bank.pe.msbootcoin.entity.BootCoin;
import com.bank.pe.msbootcoin.producer.KafkaStringProducer;
import com.bank.pe.msbootcoin.service.BootcointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/kafka")
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    private BootcointService bootcointService;

    @Autowired
    KafkaController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessage(@RequestBody BootCoin message) {
        kafkaStringProducer.sendMessage(message);
        return ResponseEntity.ok("Mensaje enviado a Kafka!");
    }

    @GetMapping(value = "/{id}")
    public Mono<BootCoin> findBy(@PathVariable String id){
        return bootcointService.findById(id);
    }
}
