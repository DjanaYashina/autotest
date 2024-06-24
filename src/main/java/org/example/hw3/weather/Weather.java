package org.example.hw3.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Headline",
        "DailyForecasts",
        "HourForecasts"
})
public class Weather {

    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts;

    @JsonProperty("HourForecasts")
    private List<HourForecast> hourForecasts;


    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline;
    }

    @JsonProperty("Headline")
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @JsonProperty("DailyForecasts")
    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }


    @JsonProperty("HourForecasts")
    public List<HourForecast> getHourForecasts() {
        return hourForecasts;
    }
}