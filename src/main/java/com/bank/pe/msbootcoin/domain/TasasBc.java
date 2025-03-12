package com.bank.pe.msbootcoin.domain;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "tasasCurrency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TasasBc {

    @BsonId
    private String id;
    private LocalDate date;
    private double tipoCambio;
    private String tipo;
    private int flag;

}
