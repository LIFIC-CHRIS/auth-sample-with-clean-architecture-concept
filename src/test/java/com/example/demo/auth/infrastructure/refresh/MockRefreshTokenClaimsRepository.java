package com.example.demo.auth.infrastructure.refresh;

import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaims;
import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaimsRepository;
import com.example.demo.common.vo.EntityUUID;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class MockRefreshTokenClaimsRepository implements RefreshTokenClaimsRepository {
    private final Map<EntityUUID, RefreshTokenClaims> store = new HashMap<>();

    @Override
    public RefreshTokenClaims save(final RefreshTokenClaims refreshTokenClaims) {
        this.store.put(refreshTokenClaims.id, refreshTokenClaims);
        return refreshTokenClaims;
    }

    @Override
    public Optional<RefreshTokenClaims> findById(final EntityUUID id) {
        return Optional.ofNullable(this.store.get(id));
    }

    @Override
    public void delete(final RefreshTokenClaims refreshTokenClaims) {
        this.store.remove(refreshTokenClaims.id);
    }

    public void reset() {
        this.store.clear();
    }
}