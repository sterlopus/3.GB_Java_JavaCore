package lession4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    Map<String, ArrayList<String>> phonebook = new HashMap<>();

    public PhoneBook() {}

    public void add (Person person) {
        if (phonebook.containsKey(person.getName())) {
            phonebook.get(person.getName()).add(person.getPhone());
        } else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(person.getPhone());
            phonebook.put(person.name, phones);
        }
    }
}


/**
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 *
 * В этот телефонный справочник с помощью метода add() можно добавлять записи,
 *
 * а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */