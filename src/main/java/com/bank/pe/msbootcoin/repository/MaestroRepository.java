package com.bank.pe.msbootcoin.repository;

import com.bank.pe.msbootcoin.domain.Maestro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends CrudRepository<Maestro, Integer> {
}
