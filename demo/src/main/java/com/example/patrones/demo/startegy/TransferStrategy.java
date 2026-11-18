package com.example.patrones.demo.startegy;

import com.example.patrones.demo.dto.TransferChannel;
import com.example.patrones.demo.dto.TransferCommand;
import com.example.patrones.demo.dto.TransferReceipt;

public interface TransferStrategy {
    TransferChannel getChannel();
    TransferReceipt execute(TransferCommand context);
}
