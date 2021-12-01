package com.example.demo.auth.application;

import com.example.demo.auth.domain.accesstoken.AccessToken;
import com.example.demo.auth.domain.accesstoken.AccessTokenCodec;
import com.example.demo.auth.domain.accesstoken.exception.AccessTokenIsExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationService.class);

    private final AccessTokenCodec accessTokenCodec;

    public AuthorizationService(final AccessTokenCodec accessTokenCodec) {
        this.accessTokenCodec = accessTokenCodec;
    }

    public void authorize(final AccessToken accessToken) {
        var accessTokenClaims = this.accessTokenCodec.decode(accessToken);

        if (accessTokenClaims.isExpired()) {
            LOGGER.info("User tried to authenticate with expired Access Token: " + accessTokenClaims.userId);
            throw new AccessTokenIsExpiredException(accessToken);
        }
    }
}
