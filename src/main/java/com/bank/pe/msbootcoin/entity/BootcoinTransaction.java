package com.bank.pe.msbootcoin.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bootcoinTransaction")
@Data
public class BootcoinTransaction {
    private String transactionId;
    private String buyerId;
    private String sellerId;
    private double amount;
    private String paymentMethod;
    private String transactionStatus;
    private LocalDateTime timestamp;
}
