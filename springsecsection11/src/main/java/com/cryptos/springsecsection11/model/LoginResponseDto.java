package com.cryptos.springsecsection11.model;

public record LoginResponseDto(
        String status,
        String jwtToken
) {
}
