package lession8.dto.daily;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("Metric")
    TemperatureData metric;
    TemperatureData imperial;


    public TemperatureData getMetric() {
        return metric;
    }

    public void setMetric(TemperatureData metric) {
        this.metric = metric;
    }

}