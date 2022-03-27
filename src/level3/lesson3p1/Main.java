package level3.lesson3p1;

import level3.lesson3p1.thirdEx.Apple;
import level3.lesson3p1.thirdEx.Box;
import level3.lesson3p1.thirdEx.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /*
    1. Написать метод, который меняет два элемента массива местами
        (массив может быть любого ссылочного типа);

    2. Написать метод который преобразует массив в ArrayList;

    3. Большая задача:
      a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
      b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
      c. Для хранения фруктов внутри коробки можете использовать ArrayList;
      d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес
       одного фрукта (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
      e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с
       той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
       (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
      f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
       (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей
        коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
      g. Не забываем про метод добавления фрукта в коробку.
     */

    public static void main(String[] args) {

        String[] blood = {
                "b",
                "l",
                "o",
                "o",
                "d"
        };
        System.out.println(Arrays.toString(blood));
        replace(blood,1,2);
        System.out.println(Arrays.toString(blood));
        System.out.println();

        System.out.println(fromArrayToList(blood));
        System.out.println();

        thirdExercise();
    }

    /*1. Написать метод, который меняет два элемента массива местами
                   (массив может быть любого ссылочного типа);*/
    private static <T extends Object> void replace(T[] arr, int index1, int index2) {
        T val1 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val1;
    }

    /*2. Написать метод который преобразует массив в ArrayList;*/
    private static <T> ArrayList<T> fromArrayToList(T[] arr) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }

    private static void thirdExercise() {
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        orangeBox1.addFruitInBox(new Orange(), 6);
        orangeBox1.showInfoBox();
        System.out.println();

        orangeBox2.addFruitInBox(new Orange(), 9);
        orangeBox2.showInfoBox();
        System.out.println();

        appleBox1.addFruitInBox(new Apple(), 9);
        appleBox1.showInfoBox();
        System.out.println();

        appleBox2.addFruitInBox(new Apple(), 11);
        appleBox2.showInfoBox();
        System.out.println();

        System.out.println(orangeBox1.compareWeight(appleBox2));
        System.out.println(appleBox1.compareWeight(orangeBox1));
        System.out.println(orangeBox2.compareWeight(orangeBox1));
        System.out.println();

        System.out.println(orangeBox1.toString());
        System.out.println(appleBox2.toString());
        System.out.println();

        orangeBox1.turnOutBoxIn(orangeBox2);
        orangeBox1.showInfoBox();
        orangeBox2.showInfoBox();
    }
}