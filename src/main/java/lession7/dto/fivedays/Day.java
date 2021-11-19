package lession7.dto.fivedays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

//    private long icon;
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;
//    private boolean hasPrecipitation;
//    private String precipitationType;
//    private String precipitationIntensity;

    public String getIconPhrase() { return iconPhrase; }
    public void setIconPhrase(String value) { this.iconPhrase = value; }

/*
    public long getIcon() { return icon; }
    public void setIcon(long value) { this.icon = value; }

    public boolean getHasPrecipitation() { return hasPrecipitation; }
    public void setHasPrecipitation(boolean value) { this.hasPrecipitation = value; }

    public String getPrecipitationType() { return precipitationType; }
    public void setPrecipitationType(String value) { this.precipitationType = value; }

    public String getPrecipitationIntensity() { return precipitationIntensity; }
    public void setPrecipitationIntensity(String value) { this.precipitationIntensity = value; }
*/
}

