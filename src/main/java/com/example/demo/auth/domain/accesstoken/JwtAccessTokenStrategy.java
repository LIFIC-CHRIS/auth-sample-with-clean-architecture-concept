package com.example.demo.auth.domain.accesstoken;

import org.springframework.stereotype.Component;

@Component
public class JwtAccessTokenStrategy implements AccessTokenCodecStrategy {
    @Override
    public AccessToken encode(AccessTokenClaims accessTokenClaims, String tokenSecretKey) {
        // TODO use jwt library
        return null;
    }

    @Override
    public AccessTokenClaims decode(AccessToken accessToken, String tokenSecretKey) {
        // TODO use jwt library
        return null;
    }
}
