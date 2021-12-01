package com.example.demo.auth.domain.refreshtoken;

import com.example.demo.auth.domain.accesstoken.AccessToken;
import com.example.demo.common.time.SystemTime;
import com.example.demo.common.vo.EntityUUID;

import java.time.Instant;

public class RefreshTokenClaims {
    public final EntityUUID id;
    public final EntityUUID userId;
    public final AccessToken accessToken;
    public final Instant publishedAt;
    public final Instant expiresAt;

    public RefreshTokenClaims(final EntityUUID userId, final AccessToken accessToken,
                              final Instant publishedAt, final Instant expiresAt) {
        this.id = new EntityUUID();
        this.userId = userId;
        this.accessToken = accessToken;
        this.publishedAt = publishedAt;
        this.expiresAt = expiresAt;
    }

    public RefreshToken getRefreshToken() {
        return new RefreshToken(this.id.value);
    }

    public boolean isExpired() {
        return this.expiresAt.isAfter(SystemTime.now());
    }

    public boolean isMatchedAccessToken(final AccessToken accessToken) {
        return this.accessToken.equals(accessToken);
    }
}
