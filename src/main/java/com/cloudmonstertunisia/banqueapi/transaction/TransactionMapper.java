package com.cloudmonstertunisia.banqueapi.transaction;


import java.time.LocalDate;

import com.cloudmonstertunisia.banqueapi.user.User;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

  public Transaction toTransaction(TransactionRequest request) {
    return Transaction.builder()
        .amount(request.getAmount())
        .destinationIban(request.getDestinationIban())
        .type(request.getType())
        .transactionDate(LocalDate.now())
        .user(
            User.builder()
                .id(request.getUserId())
                .build()
        )
        .build();
  }

  public TransactionResponse toResponse(Transaction transaction) {
    return TransactionResponse.builder()
        .amount(transaction.getAmount())
        .destinationIban(transaction.getDestinationIban())
        .type(transaction.getType())
        .transactionDate(transaction.getTransactionDate())
        .build();
  }
}
