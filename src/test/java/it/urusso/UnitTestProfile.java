package it.urusso;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Map;

public class UnitTestProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "quarkus.datasource.devservices.enabled", "false",
                "quarkus.datasource.enabled", "false",
                "quarkus.hibernate-orm.enabled", "false"
                );
    }
}
