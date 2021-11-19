package lession8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {


            System.out.println("Enter choice number: 1 - Get weather report, " +
                    "2 - Get weather forecast for next 5 days, 3 - Get all history of queries, 0 or exit - close application.");
            String result = scanner.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            if (result.equals("1") || result.equals("2")) {
                System.out.println("Input city name: ");
                String city = scanner.nextLine();
                setGlobalCity(city);
            }

            try {
                notifyController(result);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) {
        if (result.equalsIgnoreCase("exit") || result.equalsIgnoreCase("0")) {
            System.out.println("Application closed by user.");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException, SQLException {
        controller.onUserInput(input);
    }

}
