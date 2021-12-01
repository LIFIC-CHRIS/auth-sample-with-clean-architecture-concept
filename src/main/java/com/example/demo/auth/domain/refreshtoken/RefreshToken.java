package com.example.demo.auth.domain.refreshtoken;

import com.example.demo.common.vo.EntityUUID;

import java.util.Objects;

public class RefreshToken {
    public final String value;

    public RefreshToken(final String value) {
        this.value = value;
    }

    public EntityUUID asRefreshTokenClaimsId() {
        return EntityUUID.of(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefreshToken that = (RefreshToken) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
