package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.entity.BootCoin;
import com.bank.pe.msbootcoin.entity.BootcoinTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcointService {

    public Flux<BootCoin> findAll();
    public Mono<BootCoin> findById(String id);
    public Mono<BootCoin> save(BootCoin wallet);
    public Mono<Void> delete(BootCoin wallet);
    public String processPurchase(BootcoinTransaction transaction);
}
