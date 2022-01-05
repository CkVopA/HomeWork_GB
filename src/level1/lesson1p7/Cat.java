package level1.lesson1p7;

import java.util.Random;

public class Cat {
    protected String name;
    private int appetite;
    private int howManyEat;
    private boolean isSatiety;

    Random random = new Random();

    Cat (String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        howManyEat = 0;
    }

    public void getAppetite() {
        System.out.println("У "+this.name+ " "+this.appetite);
    }
    public void setHowManyEat() {
        this.howManyEat = 0;
    }
    public void setAppetite() {
        this.appetite = random.nextInt(20);
        setHowManyEat();
    }

    protected void eatFood (Plate plate){
        if (appetite == 0){
            System.out.println(this.name + " не голодное животное.");
        }

       if (plate.getQuantityOfFood() == 0) {
           this.isSatiety = false;
           System.out.println("Давай мне жрать " + this.appetite + ", кожаный ублюдок!");
       }
       if (appetite > plate.getQuantityOfFood() & plate.getQuantityOfFood() != 0) {
           howManyEat = plate.getQuantityOfFood();
           plate.degreaseFood(howManyEat);
           System.out.println(this.name+" сожрала всё под чистую!..");
           this.appetite -= howManyEat;
           this.isSatiety = false;
           System.out.println("Недостаточно еды для этого шерстяного по кличке "+ this.name);
           System.out.println("Котэ осталось доесть " + (this.appetite));
       }
       if (appetite <= plate.getQuantityOfFood() & appetite!=0) {
            plate.degreaseFood(appetite);
            System.out.println(this.name+" жуёт...");
            this.howManyEat += this.appetite;
            this.appetite = 0;
            this.isSatiety = true;
        }
    }

    public boolean chekIsSatiety (){
        if (isSatiety){
            System.out.println(this.name + " набил(а) живот до отвала.");
            return true;
        }
        else {
            System.out.println(this.name + " - голодное животное.");
            return false;
        }
    }

}
