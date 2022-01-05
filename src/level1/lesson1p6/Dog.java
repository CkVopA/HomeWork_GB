package level1.lesson1p6;

public class Dog extends Animal {

    public Dog (){
        super();
        this.name = "Дворовый пёс";
        this.maxLengthRun = 300;
        this.maxHeightJump = 0.4f;
        this.maxLengthSwimming = 4;
    }

    public Dog(String name) {
        super(name);
        maxLengthRun = 10;
        maxLengthSwimming = 3;
        maxHeightJump = 0.2f;
    }

    public Dog (String name, int maxLengthRun, float maxHeightJump) {
        super(name, maxLengthRun, maxHeightJump);
        this.maxLengthSwimming = 2;
    }

    public  Dog(String name, int maxLengthRun, float maxHeightJump, int maxLengthSwimming){
        super(name, maxLengthRun, maxHeightJump, maxLengthSwimming);
    }
}
