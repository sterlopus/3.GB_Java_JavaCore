package lession4;

public class Person {

    String name;
    String phone;

    public Person(String string, String phone) {
        this.name = string;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}



/**
 *  * 2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
 *  *
 *  * В этот телефонный справочник с помощью метода add() можно добавлять записи,
 *  * а с помощью метода get() искать номер телефона по фамилии.
 *  *
 *  * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 *  * тогда при запросе такой фамилии должны выводиться все телефоны.
 */