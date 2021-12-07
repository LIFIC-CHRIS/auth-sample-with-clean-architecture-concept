package com.example.demo.auth.application;

import com.example.demo.auth.domain.accesstoken.AccessToken;
import com.example.demo.auth.domain.refreshtoken.RefreshToken;
import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaimsRepository;
import com.example.demo.auth.domain.refreshtoken.exception.RefreshTokenClaimsIsNotFoundException;
import com.example.demo.auth.domain.refreshtoken.exception.RefreshTokenIsExpiredException;
import com.example.demo.auth.domain.refreshtoken.exception.RefreshTokenIsNotMatchedWithAccessTokenException;
import com.example.demo.common.ds.Pair;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenRefreshService {
    private final AuthTokenPublishService authTokenPublishService;
    private final RefreshTokenClaimsRepository refreshTokenClaimsRepository;

    public AuthTokenRefreshService(
            final AuthTokenPublishService authTokenPublishService,
            final RefreshTokenClaimsRepository refreshTokenClaimsRepository) {
        this.authTokenPublishService = authTokenPublishService;
        this.refreshTokenClaimsRepository = refreshTokenClaimsRepository;
    }

    public Pair<AccessToken, RefreshToken> refreshAuthTokens(final AccessToken accessToken, final RefreshToken refreshToken) {
        var refreshTokenClaims = this.refreshTokenClaimsRepository.findById(refreshToken.asRefreshTokenClaimsId())
                .orElseThrow(() -> new RefreshTokenClaimsIsNotFoundException(refreshToken));

        if (refreshTokenClaims.isExpired()) {
            throw new RefreshTokenIsExpiredException(refreshToken);
        }

        if (!refreshTokenClaims.isMatchedAccessToken(accessToken)) {
            throw new RefreshTokenIsNotMatchedWithAccessTokenException(refreshToken, accessToken);
        }

        this.refreshTokenClaimsRepository.delete(refreshTokenClaims);

        return this.authTokenPublishService.publishAuthTokens(new AuthTokenPublishService.Command(refreshTokenClaims.userId));
    }
}
