package level2.lesson2p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        firstTask();

        /*
        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         В этот телефонный справочник с помощью метода add() можно добавлять записи.
         С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
         может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны
          выводиться все телефоны.
         */
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("A", 11111111111L);
        phoneBook.add("A", 82222222222L);
        phoneBook.add("B", 89333333333L);
        phoneBook.add("B", 89253982608L);
        phoneBook.add("B", 89998887777L);
        phoneBook.add("C", 84445556655L);
        phoneBook.add("D", 89999999999L);
        phoneBook.get("B");
        phoneBook.showPhoneBook();
    }

    private static void firstTask() {
        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.
         */
        ArrayList<String> letters = new ArrayList<>(20);
        letters.add("A");
        letters.add("A");
        letters.add("B");
        letters.add("B");
        letters.add("B");
        letters.add("B");
        letters.add("A");
        letters.add("C");
        letters.add("C");
        letters.add("C");
        letters.add("C");
        letters.add("C");
        letters.add("Y");
        letters.add("D");
        letters.add("I");
        letters.add("D");
        letters.add("O");
        System.out.println(letters);
        System.out.println(letters.size());

        TreeSet<String> unicLetters = new TreeSet<>(letters);
        System.out.println(unicLetters);
        System.out.println(unicLetters.size());

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : letters) {
            hashMap.put(str, hashMap.getOrDefault(str, 0) +1);
        }
//      hashMap.put(member, num == null ? 1 : num + 1);     // с циклом foreach
        System.out.println(hashMap);
    }
}
