package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.dto.Credit;
import reactor.core.publisher.Mono;

public interface CreditService {

    Mono<Credit> findById(String id);
    Mono<Credit> save(Credit cardDebit);
}
