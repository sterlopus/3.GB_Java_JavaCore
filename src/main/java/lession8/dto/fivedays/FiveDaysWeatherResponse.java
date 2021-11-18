package lession8.dto.fivedays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FiveDaysWeatherResponse {

    @JsonProperty(value = "Headline")
    private Headline headline;
    @JsonProperty(value = "DailyForecasts")
    private DailyForecast[] dailyForecasts;


    // getters
    public Headline getHeadline() { return headline; }
    public DailyForecast[] getDailyForecasts() { return dailyForecasts; }

    // setters
    public void setHeadline(Headline value) { this.headline = value; }
    public void setDailyForecasts(DailyForecast[] value) { this.dailyForecasts = value; }
}