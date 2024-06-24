package org.example.hw3;

import io.restassured.path.json.JsonPath;
import org.example.hw3.weather.Weather;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TwelveHoursForecastsTest extends AccuweatherAbstractTest{

    @Test
    void getTwelveHoursForecasts_shouldReturn() {
        String response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        List<Map<String, Object>> jsonDataList = jsonPath.getList("$");

        Assertions.assertEquals(12, jsonDataList.size());

        for (Map<String, Object> data : jsonDataList) {
            Assertions.assertTrue(data.containsKey("EpochDateTime"));
        }
    }
}
