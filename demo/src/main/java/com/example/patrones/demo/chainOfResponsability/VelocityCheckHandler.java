package com.example.patrones.demo.chainOfResponsability;

import com.example.patrones.demo.context.TransactionContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class VelocityCheckHandler implements FraudRuleHandler {
    @Override
    public void validate(TransactionContext context, String accountNumber) {
        if(context.getTransactionsLastMinute(accountNumber) > 5){
            throw new RuntimeException("Too many transactions in the last minute for account: " + accountNumber);
        }
    }
}
