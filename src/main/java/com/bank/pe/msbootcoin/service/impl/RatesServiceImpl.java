package com.bank.pe.msbootcoin.service.impl;

import com.bank.pe.msbootcoin.entity.Rates;
import com.bank.pe.msbootcoin.repository.RatesRepository;
import com.bank.pe.msbootcoin.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class RatesServiceImpl implements RatesService {

  @Autowired
  private RatesRepository tasasBcRepository;

  @Override
  public Flux<Rates> findAll() {
    return tasasBcRepository.findAll();
  }

  @Override
  public Mono<Rates> findById(String id) {
    return tasasBcRepository.findById(id);
  }

  @Override
  public Mono<Rates> save(Rates rates) {
    return tasasBcRepository.save(rates);
  }

  @Override
  public Mono<Void> delete(Rates rates) {
    return tasasBcRepository.delete(rates);
  }

}
