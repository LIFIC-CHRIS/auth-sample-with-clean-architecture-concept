package com.example.demo.auth.domain.accesstoken;

import java.util.Objects;

public class AccessToken {
    public final String value;

    public AccessToken(final String token) {
        this.value = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessToken that = (AccessToken) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
