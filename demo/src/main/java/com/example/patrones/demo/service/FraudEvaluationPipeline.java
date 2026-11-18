package com.example.patrones.demo.service;

import com.example.patrones.demo.chainOfResponsability.FraudRuleHandler;
import com.example.patrones.demo.context.TransactionContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudEvaluationPipeline {
    private final List<FraudRuleHandler> fraudRuleHandlers;

    public void evaluate(String accountNumber){
        TransactionContext context = new TransactionContext();
        for (FraudRuleHandler handler : fraudRuleHandlers) {
            handler.validate(context, accountNumber);
        }
    }
}
