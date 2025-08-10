package com.cloudmonstertunisia.banqueapi.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

  private BigDecimal amount;
  private String destinationIban;
  private TransactionType type;
  private LocalDate transactionDate;

}
