package lession5;

import java.io.*;

public class Hw5 {

    public static void main(String[] args) throws IOException {

        // 1. Реализовать сохранение данных в csv файл;
        System.out.println("Enter characters to console, then Enter");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        System.out.println(string);

        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            fileWriter.write(string);
        }


        // 2. Реализовать загрузку данных из csv файла.
        AppData data = new AppData();

        try(BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {

            String header;
            if ((header = reader.readLine()) != null) {
                data.setHeader(header.split(","));
            }

            String dataString;
            int[][] intData = new int[5][3];
            int n = 0;

            while ((dataString = reader.readLine()) != null) {

                String[] stringData = dataString.split(",");
                    for (int i = 0; i < 3; i++) {
                        intData[n][i] = Integer.parseInt(stringData[i]);
                    }
                    n++;
            }
            data.setData(intData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // test output from AppData object
        data.printObject();

    }
}


/**
 * 1. Реализовать сохранение данных в csv файл;
 * 2. Реализовать загрузку данных из csv файла. Файл читается целиком.
 * Структура csv файла:
 *
 * | Строка заголовок с набором столбцов |
 * | Набор строк с целочисленными значениями |
 * | * Разделитель между столбцами - символ точка с запятой (;) |
 * Пример:
 *
 * Value 1;Value 2;Value 3
 * 100;200;123
 * 300,400,500
 *
 * Для хранения данных использовать класс вида:
 *
 * public class AppData {
 *   private String[] header;
 *   private int[][] data;
 *
 *  // ...
 * }
 *
 * Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 */