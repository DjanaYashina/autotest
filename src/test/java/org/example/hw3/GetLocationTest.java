package org.example.hw3;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.hw3.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetLocationTest extends AccuweatherAbstractTest{

    @Test
    void getLocation_autocomplete_returnMoscow() {

        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Moscow")
                .when()
                .get("http://dataservice.accuweather.com/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(10,response.size());
        Assertions.assertEquals("Moscow", response.get(0).getLocalizedName());
    }
}
