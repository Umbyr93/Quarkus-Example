package it.urusso.controller;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import it.urusso.UnitTestProfile;
import it.urusso.model.dto.UserDto;
import it.urusso.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestProfile(UnitTestProfile.class)
class UserControllerTest {
    @InjectMock
    private UserService userService;

    @Test
    void getByIdTest() {
        given()
          .when().get("user/1")
          .then()
             .statusCode(200);
    }

    @Test
    void getByFiscalCodeTest() {
        given()
                .queryParam("fiscalCode", "1")
                .when().get("user")
                .then()
                .statusCode(200);
    }

    @Test
    @Disabled("Doesn't call the API for some reason")
    void createUserTest() {
        var dto = new UserDto(1L, "a", "b", "c");

        given()
                .body(dto)
                .when().post("user")
                .then()
                .statusCode(200);
    }

    @Test
    @Disabled("Doesn't call the API for some reason")
    void updateUserTest() {
        var dto = new UserDto(1L, "a", "b", "c");

        given()
                .body(dto)
                .when().patch("user")
                .then()
                .statusCode(200);
    }
}