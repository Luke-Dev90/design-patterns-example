package com.example.patrones.demo.controller;

import com.example.patrones.demo.dto.PaymentDTO;
import com.example.patrones.demo.dto.TransferChannel;
import com.example.patrones.demo.dto.TransferCommand;
import com.example.patrones.demo.dto.TransferReceipt;
import com.example.patrones.demo.service.FraudEvaluationPipeline;
import com.example.patrones.demo.service.TransferRouterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/strategy")
@RequiredArgsConstructor
public class StrategyController {
    private final TransferRouterService transferRouterService;
    private final FraudEvaluationPipeline fraudEvaluationPipeline;
    @PostMapping("/excute")
    public TransferReceipt applyContextStrategy(@RequestHeader("channel") String channel, @RequestBody PaymentDTO body){
        fraudEvaluationPipeline.evaluate(body.accountNumber());
        return transferRouterService.process(TransferCommand.builder()
                .channel(channel)
                .amount(body.amount()).build());
    }
}
