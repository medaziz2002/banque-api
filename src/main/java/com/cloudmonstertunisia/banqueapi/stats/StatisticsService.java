package com.cloudmonstertunisia.banqueapi.stats;

import com.cloudmonstertunisia.banqueapi.transaction.TransactionRepository;
import com.cloudmonstertunisia.banqueapi.transaction.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final TransactionRepository transactionRepository;

    public StatisticsResponse getStats(Integer userId) {
        var accountBalance = transactionRepository.findAccountBalance(userId);
        var highestTransfer = transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.TRANSFERT);
        var highestDeposit = transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.DEPOSIT);
        return StatisticsResponse.builder()
                .accountBalance(accountBalance)
                .highestDeposit(highestDeposit)
                .highestTransfer(highestTransfer)
                .build();
    }
}
