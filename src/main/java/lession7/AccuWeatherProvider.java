package lession7;

import com.fasterxml.jackson.databind.JavaType;
import lession7.dto.daily.WeatherResponse;
import lession7.dto.fivedays.DailyForecast;
import lession7.dto.fivedays.FiveDaysWeatherResponse;
import lession7.entity.WeatherData;
import lession7.enums.Periods;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String SCHEME = "http";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public WeatherData getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();

        if (periods.equals(Periods.NOW)) { // TODAY REPORT
            HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

            Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

            Response response = client.newCall(request).execute();
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, WeatherResponse.class);
            List<WeatherResponse> weatherResponses = objectMapper.readValue(response.body().string(), type);

            WeatherData weatherData = new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),
                    "today",
                    weatherResponses.get(0).getWeatherText(),
                    weatherResponses.get(0).getTemperature().getMetric().getTemperatureValue());
            return weatherData;
        } else
        if ( periods.equals(Periods.FIVE_DAYS))    // 5 DAYS FORECAST PART
        {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme(SCHEME)
                    .host(HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegments("daily")
                    .addPathSegments("5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();

            FiveDaysWeatherResponse fiveDaysWeatherResponse = objectMapper.readValue(response.body().string(),
                    FiveDaysWeatherResponse.class);
            // Todo: send data to WeatherData[] object and return it, than use WeatherData.print() at Controller
/*
            ArrayList<WeatherData> testVar = null;
            for (DailyForecast day : fiveDaysWeatherResponse.getDailyForecasts()) {
                testVar.add(new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),
                        LocalDate.ofEpochDay(TimeUnit.SECONDS.toDays(day.getEpochDate())).toString(),
                        day.getDay().getIconPhrase(),
                        day.getTemperature().getMaximum().getValue()
                ));
            }
            return testVar.asArray;
*/
            for (DailyForecast day : fiveDaysWeatherResponse.getDailyForecasts()) {
                LocalDate date = LocalDate.ofEpochDay(TimeUnit.SECONDS.toDays(day.getEpochDate()));
                System.out.printf("Forecast for day %s: weather condition is %s and temperature is %.1fC%n",
                        date, day.getDay().getIconPhrase(), day.getTemperature().getMaximum().getValue());
            }
        } else {
            System.out.println("Wrong choice for 'periods'");
        }
        return null;
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment("locations")
            .addPathSegment(API_VERSION)
            .addPathSegment("cities")
            .addPathSegment("autocomplete")
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("q", selectedCity)
            .build();

        Request request = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(detectLocationURL)
            .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unable to find city information. " +
                "Server response code = " + response.code() + "\nresponse body = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Looking for city: " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Found city " + cityName + " in the country " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}
