package com.example.demo.auth.domain.accesstoken;

import com.example.demo.common.time.SystemTime;
import com.example.demo.common.vo.EntityUUID;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class AccessTokenClaimsGenerator {
    private final long EXPIRATION_MINUTES = 30L;

    public AccessTokenClaims generate(final EntityUUID userId) {
        var now = SystemTime.now();
        var expiresAt = this.calculateExpiresAt(now);
        return new AccessTokenClaims(userId, now, expiresAt);
    }

    private Instant calculateExpiresAt(Instant now) {
        return now.plus(EXPIRATION_MINUTES, ChronoUnit.MINUTES);
    }
}
