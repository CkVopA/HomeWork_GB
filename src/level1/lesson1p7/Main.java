/*   2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
        (например, в миске 10 еды, а кот пытается покушать 15-20)
     3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
        Если коту удалось покушать (хватило еды), сытость = true
     4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт
        (это сделано для упрощения логики программы)
     5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом
        вывести информацию о сытости котов в консоль
     */
package level1.lesson1p7;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Матильда", 15);
        cats[1] = new Cat("Тишка", 11);
        cats[2] = new Cat("Нюшка", 8);

        Plate plate = new Plate(10);
        plate.plateINFO();

        feedTheCats(cats, plate);
        System.out.println("______________________________________________");

        aFewHoursLater(cats);
        feedTheCats(cats, plate);
    }

    private static void feedTheCats(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eatFood(plate);
            if (!cat.chekIsSatiety()) {
                plate.addEatInPlate();
                cat.eatFood(plate);
                cat.chekIsSatiety();
            }
        }
        plate.plateINFO();
    }

    public static void aFewHoursLater(Cat[] cats){
        System.out.println("Прошло несколько часов и коты проголодались...");
        for (Cat cat: cats) {
            cat.setAppetite();
            cat.getAppetite();
        }
    }

}
