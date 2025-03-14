package com.bank.pe.msbootcoin;

import com.bank.pe.msbootcoin.entity.Maestro;
import com.bank.pe.msbootcoin.repository.MaestroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MsBootCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBootCoinApplication.class, args);
	}
}
