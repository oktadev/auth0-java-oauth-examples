package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestProfile(MockSecurityProfile.class)
public class ExampleResourceTest {

    @Test
    public void profile() {
        given()
                .when().get("/profile")
                .then()
                .statusCode(401);
    }
}
