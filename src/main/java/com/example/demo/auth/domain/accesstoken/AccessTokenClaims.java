package com.example.demo.auth.domain.accesstoken;

import com.example.demo.common.time.SystemTime;
import com.example.demo.common.vo.EntityUUID;

import java.time.Instant;

public class AccessTokenClaims {
    public final EntityUUID userId;
    public final Instant publishedAt;
    public final Instant expiresAt;

    public AccessTokenClaims(final EntityUUID userId, final Instant publishedAt, final Instant expiresAt) {
        this.userId = userId;
        this.publishedAt = publishedAt;
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return this.expiresAt.isAfter(SystemTime.now());
    }
}
