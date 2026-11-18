package com.example.patrones.demo.dto;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum TransferChannel {
    SWIFT("SWIFT"),
    MOBILE("MOBILE");

    private final String channel;

    TransferChannel(String channel) {
        this.channel = channel;
    }

    public static Optional<TransferChannel> fromValue(String value) {
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }
        return Arrays.stream(values())
                .filter(c -> c.channel.equalsIgnoreCase(value.trim()))
                .findFirst();
    }
}
