package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.dto.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> getAll();

    Mono<Customer> find(String id);
}
