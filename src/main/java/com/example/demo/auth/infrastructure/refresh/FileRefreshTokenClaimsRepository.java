package com.example.demo.auth.infrastructure.refresh;

import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaims;
import com.example.demo.auth.domain.refreshtoken.RefreshTokenClaimsRepository;
import com.example.demo.common.vo.EntityUUID;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FileRefreshTokenClaimsRepository implements RefreshTokenClaimsRepository {

    @Override
    public RefreshTokenClaims save(final RefreshTokenClaims refreshTokenClaims) {
        return null;
    }

    @Override
    public Optional<RefreshTokenClaims> findById(final EntityUUID id) {
        return Optional.empty();
    }

    @Override
    public void delete(final RefreshTokenClaims refreshTokenClaims) {

    }
}
