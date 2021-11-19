package lession8.dto.daily;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lession8.ApplicationGlobalState;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("Temperature")
    Temperature temperature;
    @JsonProperty("WeatherText")
    private String weatherText;
//        @JsonIgnore
//        private String city;

//        private String LocalObservationDateTime;
//        private float EpochTime;
//        private float WeatherIcon;
//        private boolean HasPrecipitation;
//        private String PrecipitationType = null;
//        private boolean IsDayTime;
//        private String MobileLink;
//        private String Link;

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }


    public void print() {
        System.out.println("========================================================================++++++++++++++++");
        System.out.println(ApplicationGlobalState.getInstance().getSelectedCity() + ": the weather conditions is: " + weatherText +
                " and the temperature is " + temperature.getMetric().getTemperatureValue() + "C");
        System.out.println("========================================================================++++++++++++++++");
    }

}


