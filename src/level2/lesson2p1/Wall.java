package level2.lesson2p1;

public class Wall extends Obstacles {

    private int heightOfTheWall;
    private int numOfTheWall;
    static int countTheWall = 0;

    public int getNumOfTheWall() {
        return numOfTheWall;
    }

    public int getHeightOfTheWall() {
        return heightOfTheWall;
    }

    Wall (int heightOfTheWall){
        countTheWall++;
        this.heightOfTheWall = heightOfTheWall;
        this.numOfTheWall = countTheWall;
    }
}
