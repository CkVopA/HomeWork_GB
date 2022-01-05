package level1.lesson1p6;

public class Obstacle {

    float heightOfWall;
    int distance;

    public Obstacle(float heightOfWall) {
        this.heightOfWall = heightOfWall;
    }

    public Obstacle(int distance){
        this.distance = distance;
    }

    public float getHeightOfWall (){
        return this.heightOfWall;
    }

    public int getDistance (){
        return this.distance;
    }
}
