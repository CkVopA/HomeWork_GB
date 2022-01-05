package level1.lesson1p6;

public class Cat extends Animal{

    public Cat(){
        super();
        this.name = "Дворовый кот";
        this.maxLengthRun = 60;
        this.maxHeightJump = 0.9f;
    }

    public Cat (String name) {
        super(name);
        maxLengthRun = 5;
        maxHeightJump = 0.2f;
    }

    public Cat (String name, float maxHeightJump){
        this.name = name;
        this.maxHeightJump = maxHeightJump;
    }

    public  Cat(String name, int maxLengthRun, float maxHeightJump){
        super(name, maxLengthRun, maxHeightJump);
    }
}
