package com.bank.pe.msbootcoin.entity;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "accounts")
public class Account {
    @BsonId
    private String id;
    private String number;
    private String type; // Ahorro, Corriente, Plazo Fijo
    private String customerId;
    private Double balance;
    private boolean hasMaintenanceFee;
    private Integer transactionLimit;
    private Double commissionFee;
    private Double minimumOpeningBalance;
    private LocalDateTime lastTransactionDate;
    private Integer freeTransactions;
    private Integer transactionCount;
    private LocalDateTime createdAt;

    public Account() {
        this.lastTransactionDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

}
