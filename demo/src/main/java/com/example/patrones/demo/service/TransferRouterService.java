package com.example.patrones.demo.service;

import com.example.patrones.demo.dto.TransferChannel;
import com.example.patrones.demo.dto.TransferCommand;
import com.example.patrones.demo.dto.TransferReceipt;
import com.example.patrones.demo.startegy.TransferStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransferRouterService {

    private final Map<TransferChannel, TransferStrategy> strategies;

    public TransferRouterService(List<TransferStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toUnmodifiableMap(
                        TransferStrategy::getChannel,
                        Function.identity()
                ));

    }

    public TransferReceipt process(TransferCommand cmd) {
        Optional<TransferChannel> channel = TransferChannel.fromValue(cmd.channel());
        TransferStrategy strategy = channel.map(strategies::get)
                .orElseThrow(() -> new RuntimeException("Canal no soportado: " + cmd.channel()));
        return strategy.execute(cmd);
    }

}
