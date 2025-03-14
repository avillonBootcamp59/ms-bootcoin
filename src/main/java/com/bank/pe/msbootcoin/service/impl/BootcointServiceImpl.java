package com.bank.pe.msbootcoin.service.impl;

import com.bank.pe.msbootcoin.entity.BootCoin;
import com.bank.pe.msbootcoin.entity.BootcoinTransaction;
import com.bank.pe.msbootcoin.producer.repository.BootCoinRepository;
import com.bank.pe.msbootcoin.service.BootcointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class BootcointServiceImpl implements BootcointService {

    private final KafkaTemplate<String, BootcoinTransaction> kafkaTemplate;

    public BootcointServiceImpl(KafkaTemplate<String, BootcoinTransaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Autowired
    public String processPurchase(BootcoinTransaction transaction) {
        transaction.setTransactionStatus("pending");
        transaction.setTimestamp(LocalDateTime.now());
        kafkaTemplate.send("bootcoin-purchase", transaction);
        return "Transaction processed";
    }

    @Autowired
    private BootCoinRepository walletRepository;

    @Override
    public Flux<BootCoin> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<BootCoin> findById(String id) {
        return walletRepository.findById(id);
    }

    @Override
    public Mono<BootCoin> save(BootCoin wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Mono<Void> delete(BootCoin wallet) {
        return walletRepository.delete(wallet);
    }

}
