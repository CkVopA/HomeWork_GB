package level1.lesson1p6;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина,
означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 */
public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Тузик");
        Dog dog2 = new Dog("Бакс", 200, 1.25f, 5);

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Кузя", 30, 1.43f);

        Obstacle wall = new Obstacle(0.43f);
        Obstacle wall2 = new Obstacle(0.56f);
        Obstacle pool1 = new Obstacle(5);
        Obstacle pool2 = new Obstacle(2);
        Obstacle track1 = new Obstacle(38);
        Obstacle track2 = new Obstacle(120);

        dog1.jumping(wall);
        cat2.jumping(wall2);
        dog2.running(track2);
        cat1.running(track1);
        dog2.swimming(pool1);
        dog1.swimming(pool2);
        cat2.swimming(pool2);
    }
}
