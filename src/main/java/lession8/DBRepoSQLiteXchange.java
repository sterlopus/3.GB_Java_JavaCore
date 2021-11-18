package lession8;

import lession8.entity.WeatherData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRepoSQLiteXchange implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String dbFilename;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "city TEXT NOT NULL, " +
            "date TEXT NOT NULL, " +
            "condition TEXT NOT NULL, " +
            "temperature REAL NOT NULL)";
    String addWeatherDataQuery = "INSERT INTO weather (city, date, condition, temperature) VALUES (?,?,?,?)";

    // constructor
    public DBRepoSQLiteXchange() {
        dbFilename = ApplicationGlobalState.getInstance().getDB_FILENAME();
    }

    // methods
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilename);
        return connection;
    }

    private void createTableIfNotExist() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveWeatherData(WeatherData weatherData) throws SQLException {
        createTableIfNotExist();
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(addWeatherDataQuery)) {
                    saveWeather.setString(1, weatherData.getCity());
                    saveWeather.setString(2, weatherData.getLocalDate());
                    saveWeather.setString(3, weatherData.getText());
                    saveWeather.setFloat(4, weatherData.getTemperature());
            saveWeather.executeUpdate();
            connection.close();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException("Error at saving data to DB attempt");
    }

/*   // TODO: wrong method, delete after all
    @Override
    public List<WeatherData> getAllSavedData() {
        // TODO: make method returning data from DB (print to console)
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
            connection.close();

            List<WeatherData> weatherDataList = new ArrayList<>();
            while (resultSet.next()) {
                WeatherData wd = new WeatherData();
                    wd.setCity(resultSet.getString("city"));
                    wd.setLocalDate(resultSet.getString("date"));
                    wd.setText(resultSet.getString("condition"));
                    wd.setTemperature(resultSet.getFloat("temperature"));
                weatherDataList.add(wd);
            }
        return weatherDataList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
*/
    @Override
    public void getAllFromDB() {
        try (Connection connection = getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnNumbers = resultSetMetaData.getColumnCount();
            for (int i = 2; i <= columnNumbers; i++) {
                System.out.print(resultSetMetaData.getColumnName(i)+"\t\t\t");
            }
            while (resultSet.next()) {
                System.out.printf("%n%s\t\t\t%s\t\t\t%s\t\t\t%f",
                        resultSet.getString("city"),
                        resultSet.getString("date"),
                        resultSet.getString("condition"),
                        resultSet.getFloat("temperature"));
            }
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
