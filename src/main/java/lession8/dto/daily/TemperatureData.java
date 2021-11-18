package lession8.dto.daily;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureData {
    @JsonProperty("Value")
    private float temperatureValue;
    private String Unit;
    private float UnitType;


    // Getter Methods
    public float getTemperatureValue() {
        return temperatureValue;
    }

    public String getUnit() {
        return Unit;
    }

    public float getUnitType() {
        return UnitType;
    }

    // Setter Methods
    public void setValue(float temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public void setUnitType(float UnitType) {
        this.UnitType = UnitType;
    }
}