package com.example.patrones.demo.chainOfResponsability;

import com.example.patrones.demo.context.TransactionContext;

public interface FraudRuleHandler {
    void validate(TransactionContext context,String accountNumber);
}
