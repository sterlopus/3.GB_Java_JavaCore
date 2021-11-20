package lession7.dto.fivedays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {

//    private OffsetDateTime date;

    @JsonProperty(value = "EpochDate")
    private long epochDate;
    @JsonProperty(value = "Temperature")
    private FiveDayTemperature temperature;
    @JsonProperty(value = "Day")
    private Day day;

//    private Day night;
//    private String[] sources;
//    private String mobileLink;
//    private String link;

//    public OffsetDateTime getDate() { return date; }
//    public void setDate(OffsetDateTime value) { this.date = value; }

    public long getEpochDate() { return epochDate; }
    public void setEpochDate(long value) { this.epochDate = value; }

    public FiveDayTemperature  getTemperature() { return temperature; }
    public void setTemperature(FiveDayTemperature  value) { this.temperature = value; }

    public Day getDay() { return day; }
    public void setDay(Day value) { this.day = value; }
/*
    public Day getNight() { return night; }
    public void setNight(Day value) { this.night = value; }

    public String[] getSources() { return sources; }
    public void setSources(String[] value) { this.sources = value; }

    public String getMobileLink() { return mobileLink; }
    public void setMobileLink(String value) { this.mobileLink = value; }

    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }
 */
}
