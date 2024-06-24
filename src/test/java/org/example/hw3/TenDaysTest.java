package org.example.hw3;

import io.restassured.http.Method;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TenDaysTest extends AccuweatherAbstractTest {

    @Test
    void getTenDays_shouldReturn401() {
        given()
                .queryParam("apikey", getApiKey())
                .pathParam("location", 294021)
                .when()
                .request(Method.GET,"http://dataservice.accuweather.com/forecasts/v1/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}