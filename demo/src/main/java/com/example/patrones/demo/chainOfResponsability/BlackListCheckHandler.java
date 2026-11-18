package com.example.patrones.demo.chainOfResponsability;

import com.example.patrones.demo.context.TransactionContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class BlackListCheckHandler implements FraudRuleHandler {
    @Override
    public void validate(TransactionContext context, String accountNumber) {
        if(context.isBlacklisted(accountNumber)) {
            throw new RuntimeException("Account " + accountNumber + " is blacklisted.");
        }
    }
}
