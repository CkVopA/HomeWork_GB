package level2.lessson2p3;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
       2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        В этот телефонный справочник с помощью метода add() можно добавлять записи.
        С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
        может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны
         выводиться все телефоны.
        */
public class PhoneBook {

    private Map<String, ArrayList<Long>> book = new HashMap<>();

    public void add(String surname, Long phone) {
        ArrayList<Long> phoneList = book.get(surname);
        if (phoneList == null){
            phoneList = new ArrayList<>();
        }
        phoneList.add(phone);
        phoneList.trimToSize();
        book.put(surname, phoneList);
    }

    public void get(String surname){
        System.out.println("Фамилия "+ surname + ", номер телефона: " + book.get(surname));
    }

    public void showPhoneBook() {
        for (HashMap.Entry<String, ArrayList<Long>> entry : book.entrySet()){
            System.out.println(MessageFormat.format(
                    "Для контакта с фамилией {0} найдены номера {1}", entry.getKey(), entry.getValue()));
        }
    }
}
