package com.bank.pe.msbootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  @BsonId
  private String id;
  private String name;
  private String type; // Personal o Empresarial

  @Indexed(unique = true)
  private String numberDocument; // DNI o RUC
  private String email;
  private String profile; // VIP, PYME



}
