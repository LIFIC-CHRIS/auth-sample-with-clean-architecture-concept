package com.example.demo.auth.domain.accesstoken.exception;

import com.example.demo.auth.domain.accesstoken.AccessToken;

public class AccessTokenIsInvalidException extends RuntimeException {
    public AccessTokenIsInvalidException(final AccessToken accessToken) {
        super("Access Token is invalid: " + accessToken.value);
    }
}
