package com.example.demo.auth.domain.accesstoken;

public interface AccessTokenCodecStrategy {

    AccessToken encode(AccessTokenClaims accessTokenClaims, String tokenSecretKey);

    AccessTokenClaims decode(AccessToken accessToken, String tokenSecretKey);
}
