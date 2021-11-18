package lession8;

public class WeatherDBApp {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();

    }
}


/**
 * 1. Добавить поддержку SQLite в проект. // SQlite_jdbc_xerial added, DONE
 * 2. Создать класс-репозиторий, отвечающий за взаимодействие с базой данных. //WeatherData added, DONE
 * 3. Организовать запись данных в базу при каждом успешном API запросе.   // realised at "Controller"
 *          Формат - String city, String localDate, String weatherText, Double temperature. //
 * 4. Организовать чтение из базы всех данных по пункту меню (требует переработки меню) // released at repository
 * 5. Учесть, что соединение всегда нужно закрывать //
 */