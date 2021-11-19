package lession8;

import lession8.entity.WeatherData;
import lession8.enums.Functionality;
import lession8.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap<>();
    DatabaseRepository repoSQLiteXchange = new DBRepoSQLiteXchange();
    WeatherData weatherData = new WeatherData();


    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_ALL_FROM_DB);

    }

    public void onUserInput(String input) throws IOException, SQLException {
        int command = Integer.parseInt(input);

        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                weatherData = getCurrentWeather();
                repoSQLiteXchange.saveWeatherData(weatherData);
                weatherData.print();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_ALL_FROM_DB:
                getAllFromDatabase();
                break;
        }
    }


    public WeatherData getCurrentWeather() throws IOException {
        return weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }

    public void getAllFromDatabase() throws IOException {
        List<WeatherData> weatherDataList = repoSQLiteXchange.getAllSavedData();
        for (WeatherData weatherData : weatherDataList) {
            System.out.println(weatherData);
        }
    }

}
