package com.example.demo.auth.application;

import com.example.demo.auth.domain.accesstoken.AccessToken;
import com.example.demo.auth.domain.accesstoken.AccessTokenClaimsGenerator;
import com.example.demo.auth.domain.accesstoken.AccessTokenCodec;
import com.example.demo.auth.domain.refreshtoken.RefreshToken;
import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaimsGenerator;
import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaimsRepository;
import com.example.demo.common.ds.Tuple;
import com.example.demo.common.vo.EntityUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenPublishService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenPublishService.class);

    private final AccessTokenClaimsGenerator accessTokenClaimsGenerator;
    private final AccessTokenCodec accessTokenCodec;

    private final RefreshTokenClaimsGenerator refreshTokenClaimsGenerator;
    private final RefreshTokenClaimsRepository refreshTokenClaimsRepository;

    public AuthTokenPublishService(
            final AccessTokenClaimsGenerator accessTokenClaimsGenerator,
            final AccessTokenCodec accessTokenCodec,
            final RefreshTokenClaimsGenerator refreshTokenClaimsGenerator,
            final RefreshTokenClaimsRepository refreshTokenClaimsRepository) {
        this.accessTokenClaimsGenerator = accessTokenClaimsGenerator;
        this.accessTokenCodec = accessTokenCodec;
        this.refreshTokenClaimsGenerator = refreshTokenClaimsGenerator;
        this.refreshTokenClaimsRepository = refreshTokenClaimsRepository;
    }

    public Tuple<AccessToken, RefreshToken> publishAuthTokens(final Command command) {
        var accessToken = this.publishAccessToken(command.userId);
        var refreshToken = this.publishRefreshToken(command.userId, accessToken);
        LOGGER.info("User published new auth tokens: " + command.userId.value);
        return new Tuple<>(accessToken, refreshToken);
    }

    private AccessToken publishAccessToken(final EntityUUID userId) {
        var accessTokenClaims = this.accessTokenClaimsGenerator.generate(userId);
        return this.accessTokenCodec.encode(accessTokenClaims);
    }

    private RefreshToken publishRefreshToken(final EntityUUID userId, final AccessToken accessToken) {
        var refreshTokenClaims = this.refreshTokenClaimsGenerator.generate(userId, accessToken);
        this.refreshTokenClaimsRepository.save(refreshTokenClaims);
        return refreshTokenClaims.getRefreshToken();
    }

    public static class Command {
        public final EntityUUID userId;

        public Command(final EntityUUID userId) {
            this.userId = userId;
        }
    }
}
