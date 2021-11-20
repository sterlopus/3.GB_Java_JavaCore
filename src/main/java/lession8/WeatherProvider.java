package lession8;

import lession8.entity.WeatherData;
import lession8.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {
    WeatherData getWeather(Periods period) throws IOException;
}
