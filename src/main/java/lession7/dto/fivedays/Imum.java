package lession7.dto.fivedays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lession7.enums.Unit;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Imum {

    @JsonProperty(value = "Value")
    private float value;

/*
    @JsonProperty(value = "Unit")
    private Unit unit;

    @JsonProperty(value = "UnitType")
    private long unitType;
*/


    public float getValue() { return value; }
    public void setValue(float value) { this.value = value; }
/*
    public Unit getUnit() { return unit; }
    public void setUnit(Unit value) { this.unit = value; }

    public long getUnitType() { return unitType; }
    public void setUnitType(long value) { this.unitType = value; }

 */
}
