package lession2;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int x, int y) {
        super("Error: wrong data at position: " + x + " x " + y);
    }
}