package lession7;

import lession7.entity.WeatherData;
import lession7.enums.Periods;
import java.io.IOException;

public interface WeatherProvider {
    WeatherData getWeather(Periods period) throws IOException;
}
