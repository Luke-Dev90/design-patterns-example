package com.example.patrones.demo.startegy;

import com.example.patrones.demo.dto.TransferChannel;
import com.example.patrones.demo.dto.TransferCommand;
import com.example.patrones.demo.dto.TransferReceipt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MobileTransferStrategyImpl implements TransferStrategy {
    @Override
    public TransferChannel getChannel() {
        return TransferChannel.MOBILE;
    }

    @Override
    public TransferReceipt execute(TransferCommand context) {
         return TransferReceipt.builder()
                 .transferChannel(getChannel().toString())
                 .amount(context.amount())
                 .message("Transferencia realizada con éxito a través de Mobile")
                 .build();
    }
}
