package lession1.hw1;

public class Athlete {

    String name;
    int length; // ability to run distance
    int high;   // ability to jump crossbar
    int depth;  // ability to swim pool
    boolean finish = true;  //  set false if any obstacle failed

    public Athlete(String name, int length, int high, int depth) {
        this.name = name;
        this.length = length;
        this.high = high;
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getHigh() {
        return high;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

}
