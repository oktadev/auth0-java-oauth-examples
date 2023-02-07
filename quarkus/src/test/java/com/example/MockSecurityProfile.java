package com.example;

import io.quarkus.test.junit.QuarkusTestProfile;
import java.util.Map;

public class MockSecurityProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "quarkus.oidc.enabled", "false",
                "quarkus.oidc.auth-server-url", "https://example.com",
                "quarkus.oidc.client-id", "test-client-id",
                "quarkus.oidc.credentials.secret", "test-secret"
        );
    }
}
