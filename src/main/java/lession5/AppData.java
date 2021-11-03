package lession5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AppData {

    private String[] header;
    private int[][] data;

    public AppData() {

    }

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }


    public void printObject() {

        for (String s : header) { // print headers
            System.out.print(s+"\t\t");
        }

        System.out.println("\n------------------------------");

        for (int[] arrays : data) { //print data
            for (int arrays2 : arrays) {
                System.out.print(arrays2 + "\t\t\t");
            }
            System.out.println();
        }
    }
}
