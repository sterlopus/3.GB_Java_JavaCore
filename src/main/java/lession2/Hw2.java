package lession2;


public class Hw2 {

    public static void main(String[] args) {

        // sample arrays with different kind of data
        String[][] wrongSizeArray, wrongDataArray, goodArray;

        wrongSizeArray = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"}
        };

        wrongDataArray = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "WRONG", "1"},
                {"1", "1", "1", "1"}
        };

        goodArray = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        // end of sample data arrays


        // testing of arrays (repeated 3 times to show different states)
        try { sumOfArray(wrongSizeArray);
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try { sumOfArray(wrongDataArray);
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try { sumOfArray(goodArray);
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    // method for check and summarize array data
    private static void sumOfArray(String[][] array) throws MyArraySizeException {

        // check if array is 4x4, throw exception if not
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }

        // summarize all array's fields, throw exception if array has no digital data with wrong field coordinates
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                        throw new MyArrayDataException(++i, ++j);
                }
            }
        }

        //  print total sum of array
        System.out.println("Sum of array = " + sum);
    }
    // end of method
}