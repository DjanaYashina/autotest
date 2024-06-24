package org.example.hw3;

import org.example.hw3.location.Region;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class GetRegionTest extends AccuweatherAbstractTest {
    @Test
    void getRegions(){

        List<Region> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/locations/v1/regions")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Region.class);

        Assertions.assertEquals(10, result.size());;
    }
    @Test
    void testCheckEuropeRegionID() {
        List<Region> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/locations/v1/regions")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Region.class);

        Region europe = null;
        for (Region region : result) {
            if ("Europe".equals(region.getLocalizedName())) {
                europe = region;
                break;
            }
        }

        Assertions.assertNotNull(europe, "Europe region not found in the response.");
        Assertions.assertEquals("EUR", europe.getId(), "Expected ID for Europe region is not 'EUR'.");
    }
}
