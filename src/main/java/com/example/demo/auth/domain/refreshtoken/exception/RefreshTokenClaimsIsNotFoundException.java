package com.example.demo.auth.domain.refreshtoken.exception;

import com.example.demo.auth.domain.refreshtoken.RefreshToken;

public class RefreshTokenClaimsIsNotFoundException extends RuntimeException {
    public RefreshTokenClaimsIsNotFoundException(final RefreshToken refreshToken) {
        super("Refresh Token Claims for the Refresh Token is not found: " + refreshToken.value);
    }
}
