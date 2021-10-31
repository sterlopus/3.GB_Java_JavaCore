package lession4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Hw4 {

    // base set of words for creating random 20-word array
    public static String[] loremIpsum = {"lorem",  "ipsum",  "dolor", "sit",  "amet", "consectetur", "adipiscing", "fall",
            "elit", "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua"
    };


    public static void main(String[] args) {

    // todo: PART ONE (Unique words)
        final int ARRAY_LENGTH = 20;

        // create 20-word array with partially repeating words from base set, then print to console
        String[] wordArray = new String[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            wordArray[i] = loremIpsum[(int) (Math.random() * 20)];
        }
        ArrayList<String> wordArrayList = new ArrayList<>(Arrays.asList(wordArray));
        System.out.println("Initial words array is: \n" + wordArrayList);


        System.out.println("\nНайти и вывести список уникальных слов, из которых состоит массив:");
        HashSet<String> uniqueWords = new HashSet<>(wordArrayList);
        System.out.println(uniqueWords);


        System.out.println("\nПосчитать, сколько раз встречается каждое слово: ");
        for (String word : uniqueWords) {
            System.out.printf("Word %s repeated %d times\n", word, Collections.frequency(wordArrayList, word));
        }
    // todo: end of PART ONE



    // todo: PART TWO - PhoneBook
        PhoneBook pb = new PhoneBook();     // create new PhoneBook

        pb.add(new Person("Johnson", "+7 111 111-11-11"));      // add some persons to phonebook
        pb.add(new Person("Smith", "+7 111 111-11-12"));
        pb.add(new Person("Mississippi", "+7 111 111-11-13"));
        pb.add(new Person("Mc'Cormick", "+7 111 111-11-14"));
        pb.add(new Person("Johnson", "+7 111 111-11-15"));
        pb.add(new Person("Smirnoff", "+7 111 111-11-16"));


        System.out.println("Smirnoff: " + pb.phonebook.get("Smirnoff"));    // get simple sample (sorry for)
        System.out.println("Johnson: " + pb.phonebook.get("Johnson"));      // get doubled sample
    //todo: end of PART TWO

    }
}


/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 *
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 *
 * Посчитать, сколько раз встречается каждое слово.
 *
 *
 */