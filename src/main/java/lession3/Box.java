package lession3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit, int quantity) {
        for (int i = 0; i < quantity; i++) {
            fruits.add(fruit);
        }
    }

    public float getBoxWeight(){
        if (fruits.isEmpty()) {
            return 0.0f;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> anotherBox) {
       return this.getBoxWeight() == anotherBox.getBoxWeight();
    }

    public void pourTo(Box<T> anotherBox) {
        anotherBox.fruits.addAll(fruits);
        fruits.clear();
    }

}