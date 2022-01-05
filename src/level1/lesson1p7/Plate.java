package level1.lesson1p7;

import java.util.Scanner;

public class Plate {

    Scanner scanner = new Scanner(System.in);
    private int quantityOfFood;


    Plate (int quantityOfFood) {
        this.quantityOfFood = quantityOfFood;
    }

    protected void plateINFO (){
        System.out.println("В миске "+this.quantityOfFood+ " еды.");
    }

    protected int getQuantityOfFood(){
        return quantityOfFood;
    }

    protected void degreaseFood (int appetite){
        if (getQuantityOfFood() == 0){
            System.out.println("В миске нет еды!");
        }
        else {this.quantityOfFood -= appetite;}
    }

//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    protected void addEatInPlate (){
        System.out.println("Сколько еды добавить в миску?..");
        int addEat = scanner.nextInt();
        quantityOfFood += addEat;
        if (addEat > 0) {
            System.out.println("В миску добавлено " + addEat + " единиц еды.");
            plateINFO();
            System.out.println();
        }
        if (addEat == 0) {
            System.out.println("Оставайся голодным, комок шерсти!");
        }
        if (addEat < 0){
            System.out.println("Должно быть положительное число...");
            addEatInPlate();
        }
    }


}
