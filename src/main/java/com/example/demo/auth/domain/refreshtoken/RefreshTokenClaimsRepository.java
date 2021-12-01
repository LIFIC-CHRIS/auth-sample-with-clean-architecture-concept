package com.example.demo.auth.domain.refreshtoken;

import com.example.demo.common.vo.EntityUUID;

import java.util.Optional;

public interface RefreshTokenClaimsRepository {
    RefreshTokenClaims save(RefreshTokenClaims refreshTokenClaims);

    Optional<RefreshTokenClaims> findById(EntityUUID id);

    void delete(RefreshTokenClaims refreshTokenClaims);
}
