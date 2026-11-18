package com.example.patrones.demo.context;

import java.util.List;
import java.util.Map;

public class TransactionContext {
    private final static List<String> blacklistedAccounts = List.of("1234", "1238", "1236");
    private final Map<String,Integer> transactionCounts = Map.of(
            "1234", 5,
            "1235", 10,
            "1236", 15
    );

    public Boolean isBlacklisted(String accountNumber) {
        return blacklistedAccounts.contains(accountNumber);
    }

    public Integer getTransactionsLastMinute(String accountNumber) {
        return transactionCounts.getOrDefault(accountNumber, 0);
    }
}
