package lession8;


import lession8.entity.WeatherData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// Репозиторий для работы
public interface DatabaseRepository {

    void saveWeatherData(WeatherData weatherData) throws SQLException;

//    List<WeatherData> getAllSavedData() throws IOException;  TODO: wrong method delete after all

    void getAllFromDB();
}
