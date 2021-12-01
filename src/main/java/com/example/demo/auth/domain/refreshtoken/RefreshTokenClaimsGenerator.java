package com.example.demo.auth.domain.refreshtoken;

import com.example.demo.auth.domain.accesstoken.AccessToken;
import com.example.demo.common.time.SystemTime;
import com.example.demo.common.vo.EntityUUID;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class RefreshTokenClaimsGenerator {
    private final long EXPIRATION_DAYS = 7L;

    public RefreshTokenClaims generate(final EntityUUID userId, final AccessToken accessToken) {
        var now = SystemTime.now();
        var expiresAt = this.calculateExpiresAt(now);
        return new RefreshTokenClaims(userId, accessToken, now, expiresAt);
    }

    private Instant calculateExpiresAt(Instant now) {
        return now.plus(EXPIRATION_DAYS, ChronoUnit.DAYS);
    }
}
