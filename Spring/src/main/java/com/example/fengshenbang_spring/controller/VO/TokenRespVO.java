package com.example.fengshenbang_spring.controller.VO;

import lombok.Data;

@Data
public class TokenRespVO {
    private String accessToken;
    private String refreshToken;
    public TokenRespVO(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
