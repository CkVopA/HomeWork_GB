package level1.lesson1p5;

public class Main {
/*

* Создать массив из 5 сотрудников
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

    public static void main(String[] args) {

        Employee[] arrayEmployes = new Employee[5];
        arrayEmployes[0] = new Employee("Зубатов", "Дмитрий", "Валерьевич", "Начальник отдела", "zubatov@mail.ru", 898223141, 93000,40);
        arrayEmployes[1] = new Employee("Пантелеев", "Андрей", "Витальевич", "Начальник отдела", "pantelemon@mail.ru", 89823247, 98600,45);
        arrayEmployes[2] = new Employee("Галкин", "Владимир", "Евгеньевич", "Инженер отдела", "jackdaw@mail.ru", 899245387, 69000,25);
        arrayEmployes[3] = new Employee("Стрижак", "Галина", "Анатольевна", "Инженер-электроник", "отсутствует", 83233554, 25000,69);
        arrayEmployes[4] = new Employee("Спасибухова", "Татьяна", "Николаевна", "техник отдела", "buhatvsem@mail.ru", 899932199, 24500,35);

        for (int i = 0; i < arrayEmployes.length; i++) {
            if (arrayEmployes[i].getAge() > 40) {
                arrayEmployes[i].showEmployeeInfo();
            }
        }

    }
}
