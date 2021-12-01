package com.example.demo.ui.web.auth;

import com.example.demo.auth.application.AuthTokenPublishService;
import com.example.demo.auth.application.AuthTokenRefreshService;
import com.example.demo.auth.application.AuthorizationService;

// TODO add Spring Web features
public class AuthController {
    private final AuthTokenPublishService authTokenPublishService;
    private final AuthTokenRefreshService authTokenRefreshService;
    private final AuthorizationService authorizationService;

    public AuthController(
            final AuthTokenPublishService authTokenPublishService,
            final AuthTokenRefreshService authTokenRefreshService,
            final AuthorizationService authorizationService) {
        this.authTokenPublishService = authTokenPublishService;
        this.authTokenRefreshService = authTokenRefreshService;
        this.authorizationService = authorizationService;
    }
}
