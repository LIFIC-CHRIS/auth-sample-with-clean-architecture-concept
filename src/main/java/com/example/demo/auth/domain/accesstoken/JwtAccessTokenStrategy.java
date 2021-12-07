package com.example.demo.auth.domain.accesstoken;

import org.springframework.stereotype.Component;

@Component
public class JwtAccessTokenStrategy implements AccessTokenCodecStrategy {
    @Override
    public AccessToken encode(final AccessTokenClaims accessTokenClaims, final String tokenSecretKey) {
        // TODO use jwt library
        return null;
    }

    @Override
    public AccessTokenClaims decode(final AccessToken accessToken, final String tokenSecretKey) {
        // TODO use jwt library
        return null;
    }
}
