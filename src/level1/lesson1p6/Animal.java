package level1.lesson1p6;
public abstract class  Animal {

    String name;
    int maxLengthRun;
    int maxLengthSwimming;
    float maxHeightJump;

    Animal(){
        this.maxLengthSwimming = 0;
    }

    Animal(String name){
        super();
        this.name = name;
    }

    public Animal(String name, int maxLengthRun, float maxHeightJump) {
        super();
        this.name = name;
        this.maxLengthRun = maxLengthRun;
        this.maxHeightJump = maxHeightJump;
    }

    Animal(String name, int maxLengthRun, float maxHeightJump, int maxLengthSwimming){
        this.name = name;
        this.maxLengthRun = maxLengthRun;
        this.maxHeightJump = maxHeightJump;
        this.maxLengthSwimming = maxLengthSwimming;
    }



    public void jumping (Obstacle wall){
        if (maxHeightJump >= wall.getHeightOfWall()){
            System.out.println(this.name + " запрыгнул(а) на препятствие высотой " + wall.getHeightOfWall() + " метров.");
        }
        if (maxHeightJump < wall.getHeightOfWall()){
            System.out.println(this.name + " не смог запрыгнуть на высоту " + wall.getHeightOfWall() + " метров.");
        }
    }

    public void running (Obstacle track){
        if (maxLengthRun >= track.getDistance()){
            System.out.println(this.name + " пробежал " + track.getDistance() + " метров.");
        }
        if (maxLengthRun < track.getDistance()){
            System.out.println(this.name + " выдохся и не пробежал " + track.getDistance() + " метров.");
        }
    }

    public  void swimming (Obstacle pool){
        if (maxLengthSwimming >= pool.getDistance()){
            System.out.println(this.name + " проплыл " + pool.getDistance() + " метров.");
        }
        if (maxLengthSwimming < pool.getDistance()){
            System.out.println(this.name + " не смог проплыть " + pool.getDistance() + " метров и утонул. =(");
        }
    }
}
