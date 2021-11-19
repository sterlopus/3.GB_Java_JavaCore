package lession8.dto.fivedays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FiveDayTemperature {

    @JsonProperty(value = "Minimum")
    private Imum minimum;
    @JsonProperty(value = "Maximum")
    private Imum maximum;

    public Imum getMinimum() {
        return minimum;
    }

    public void setMinimum(Imum value) {
        this.minimum = value;
    }

    public Imum getMaximum() {
        return maximum;
    }

    public void setMaximum(Imum value) {
        this.maximum = value;
    }
}
