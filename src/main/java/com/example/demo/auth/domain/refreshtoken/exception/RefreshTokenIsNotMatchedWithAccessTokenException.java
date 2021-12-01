package com.example.demo.auth.domain.refreshtoken.exception;

import com.example.demo.auth.domain.accesstoken.AccessToken;
import com.example.demo.auth.domain.refreshtoken.RefreshToken;

public class RefreshTokenIsNotMatchedWithAccessTokenException extends RuntimeException {
    public RefreshTokenIsNotMatchedWithAccessTokenException(final RefreshToken refreshToken, final AccessToken accessToken) {
        super("Refresh Token is not matched with Access Token: " + refreshToken.value + ", " + accessToken.value);
    }
}
