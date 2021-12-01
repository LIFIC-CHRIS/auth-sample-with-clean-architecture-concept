package com.example.demo.auth.domain.refreshtoken.exception;

import com.example.demo.auth.domain.refreshtoken.RefreshToken;

public class RefreshTokenIsExpiredException extends RuntimeException {
    public RefreshTokenIsExpiredException(final RefreshToken refreshToken) {
        super("Refresh Token is expired + " + refreshToken.value);
    }
}
