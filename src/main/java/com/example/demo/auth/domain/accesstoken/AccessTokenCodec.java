package com.example.demo.auth.domain.accesstoken;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenCodec {
    private final String tokenSecretKey;
    private final AccessTokenCodecStrategy strategy;

    public AccessTokenCodec(
            @Value("${auth.token.secret-key}") final String tokenSecretKey,
            final AccessTokenCodecStrategy strategy) {
        this.tokenSecretKey = tokenSecretKey;
        this.strategy = strategy;
    }

    public AccessToken encode(AccessTokenClaims accessTokenClaims) {
        return this.strategy.encode(accessTokenClaims, tokenSecretKey);
    }

    /**
     * @throws com.example.demo.auth.domain.accesstoken.exception.AccessTokenIsInvalidException
     */
    public AccessTokenClaims decode(AccessToken accessToken) {
        return this.strategy.decode(accessToken, tokenSecretKey);
    }
}
