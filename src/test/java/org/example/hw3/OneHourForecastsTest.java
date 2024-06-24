package org.example.hw3;

import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.example.hw3.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OneHourForecastsTest extends AccuweatherAbstractTest{

    @Test
    void getOneHourForecasts_shouldReturn() {

        String response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        List<Map<String, Object>> jsonDataList = jsonPath.getList("$");

        Assertions.assertEquals(1, jsonDataList.size());

        for (Map<String, Object> data : jsonDataList) {
            Assertions.assertTrue(data.containsKey("EpochDateTime"));
        }
    }
}
