package lession6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CityWeatherForecast {

    final static String SCHEME = "https";
    final static String HOST = "api.weather.yandex.ru";
    final static String RELEASE = "v2";
//    final static String SERVICE = "forecast"; - free access finished, only daily forecast available
    final static String SERVICE = "informers";
    final static String LANGUAGE = "ru_RU";
    final static String APIKEY = "X-Yandex-API-Key";
    final static String APIKEYVALUE = "2a155908-6074-4b5e-83d7-f2db755b6f43";

    String getAll(String lat, String lon) {

        HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(RELEASE)
                .addPathSegment(SERVICE)
                .addQueryParameter("lat", lat )
                .addQueryParameter("lon", lon)
                .addQueryParameter("lang", LANGUAGE)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader(APIKEY, APIKEYVALUE)
                .build();

        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return "Some data error";
    }

}

//
// Base Yandex-API details:
// [header: API key] = X-Yandex-API-Key : 2a155908-6074-4b5e-83d7-f2db755b6f43
//
// request format:
// GET https://api.weather.yandex.ru/v2/informers?
// lat=<широта>
// & lon=<долгота>
// & [lang=<язык ответа>]
//