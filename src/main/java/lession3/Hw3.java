package lession3;

public class Hw3 {

    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        appleBox1.addFruit(new Apple(),3);
        appleBox2.addFruit(new Apple(),6);
        orangeBox1.addFruit(new Orange(), 4);
        orangeBox2.addFruit(new Orange(), 1);

        System.out.println("First box with apples weight = " + appleBox1.getBoxWeight());
        System.out.println("Second box with apples weight = " + appleBox2.getBoxWeight());
        System.out.println("First box with oranges weight = " + orangeBox1.getBoxWeight());
        System.out.println("Second box with oranges weight = " + orangeBox2.getBoxWeight());

        System.out.println("");

        System.out.println("Is boxes weights equals: " + appleBox2.compare(orangeBox1));
        System.out.println("Is boxes weights equals: " + appleBox1.compare(orangeBox1));

        System.out.println("");

        orangeBox1.pourTo(orangeBox2);
        System.out.println("First box with oranges weight = " + orangeBox1.getBoxWeight());
        System.out.println("Second box with oranges weight = " + orangeBox2.getBoxWeight());

    }

}


/**

 Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

 Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

 Для хранения фруктов внутри коробки можно использовать ArrayList;

 Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

 Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
    которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
    Можно сравнивать коробки с яблоками и апельсинами;

 Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку
    фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
    а в другую перекидываются объекты, которые были в первой;

 Не забываем про метод добавления фрукта в коробку.

 */