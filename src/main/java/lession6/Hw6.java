package lession6;

public class Hw6 {

    public static void main(String[] args) {

        String lat = "59.939099"; //St.Petersburg geo coordinates
        String lon = "30.315877";

        CityWeatherForecast forecast = new CityWeatherForecast();
        System.out.println("\nToday's Forecast for Saint-Petersburg is: \n" + forecast.getAll(lat, lon));
    }
}

/**
 * С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
 * пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
 *
 * Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться,
 * зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
 * Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед (этого достаточно
 * для выполнения д/з).
 */