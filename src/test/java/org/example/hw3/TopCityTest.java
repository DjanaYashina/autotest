package org.example.hw3;

import org.example.hw3.location.Location;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;


public class TopCityTest extends AccuweatherAbstractTest{
    @Test
    void getTopCity() {

        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/locations/v1/topcities/50")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(50,response.size());
        Assertions.assertEquals("Dhaka", response.get(0).getLocalizedName());

    }


}
