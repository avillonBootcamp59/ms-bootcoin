package com.bank.pe.msbootcoin.repository;

import com.bank.pe.msbootcoin.entity.Rates;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RatesRepository extends ReactiveMongoRepository<Rates, String> {
}
