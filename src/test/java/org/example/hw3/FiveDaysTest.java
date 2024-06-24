package org.example.hw3;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.hw3.weather.Weather;


import static io.restassured.RestAssured.given;

public class FiveDaysTest extends AccuweatherAbstractTest{
    @Test
    void getWeatherFiveDays_shouldReturn() {

        Weather weather = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(5, weather.getDailyForecasts().size());
    }

    @Test
    void testFiveDays() {

        Weather weather = given().queryParam("apikey", getApiKey())
                .when()
                .get("http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().as(Weather.class);

        Assertions.assertEquals(5, weather.getDailyForecasts().size());;
        Assertions.assertEquals("F", weather.getDailyForecasts().get(0).getTemperature().getMaximum().getUnit());
        Assertions.assertNotNull(weather.getHeadline());
    }

}
