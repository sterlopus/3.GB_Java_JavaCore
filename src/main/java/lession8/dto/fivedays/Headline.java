package lession8.dto.fivedays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {

    @JsonProperty(value = "EffectiveDate")
    private String effectiveDate;
/*
    private long effectiveEpochDate;
    private long severity;

    @JsonProperty(value = "Text")
    private String text;

    private String category;
    private OffsetDateTime endDate;
    private long endEpochDate;
    private String mobileLink;
    private String link;
*/
    public String getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(String value) { this.effectiveDate = value; }
/*
    public long getEffectiveEpochDate() { return effectiveEpochDate; }
    public void setEffectiveEpochDate(long value) { this.effectiveEpochDate = value; }

    public long getSeverity() { return severity; }
    public void setSeverity(long value) { this.severity = value; }

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    public String getCategory() { return category; }
    public void setCategory(String value) { this.category = value; }

    public OffsetDateTime getEndDate() { return endDate; }
    public void setEndDate(OffsetDateTime value) { this.endDate = value; }

    public long getEndEpochDate() { return endEpochDate; }
    public void setEndEpochDate(long value) { this.endEpochDate = value; }

    public String getMobileLink() { return mobileLink; }
    public void setMobileLink(String value) { this.mobileLink = value; }

    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }

     */
}
