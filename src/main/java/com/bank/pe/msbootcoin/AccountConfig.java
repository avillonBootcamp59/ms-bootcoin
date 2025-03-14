package com.bank.pe.msbootcoin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class AccountConfig {

    @Value("${endpoint.accounts}")
    private String url;

}
