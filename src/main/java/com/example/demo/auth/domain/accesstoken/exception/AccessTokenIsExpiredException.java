package com.example.demo.auth.domain.accesstoken.exception;

import com.example.demo.auth.domain.accesstoken.AccessToken;

public class AccessTokenIsExpiredException extends RuntimeException {
    public AccessTokenIsExpiredException(final AccessToken accessToken) {
        super("Access Token is expired: " + accessToken.value);
    }
}
