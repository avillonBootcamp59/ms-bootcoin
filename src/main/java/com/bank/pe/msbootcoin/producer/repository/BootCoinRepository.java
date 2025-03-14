package com.bank.pe.msbootcoin.producer.repository;

import com.bank.pe.msbootcoin.entity.BootCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin, String> {

}
