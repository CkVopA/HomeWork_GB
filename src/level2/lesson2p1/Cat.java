package level2.lesson2p1;

public class Cat extends Participants {

    private static int countCat = 0;

    protected int numOfCat;

    public int getNumOfCat() {
        return numOfCat;
    }

    public Cat(int runRestriction, int heightRestriction) {
        countCat++;
        this.runRestriction = runRestriction;
        this.heightRestriction = heightRestriction;
        this.numOfCat = countCat;
    }

    @Override
    public void run(Racetrack racetrack) {
        if (hasRunPossibility(racetrack)) {
            System.out.println("The cat"+numOfCat+" has run this distance"+ racetrack.getNumOfTheRacetrack());
        }
        if (!hasRunPossibility(racetrack)){
            System.out.println("The cat"+numOfCat+" has not run this distance"+ racetrack.getNumOfTheRacetrack());
        }
    }

    @Override
    public void jump(Wall wall) {
        if (hasJumpPossibility(wall)){
            System.out.println("The cat"+numOfCat+" has jumped over a wall"+wall.getNumOfTheWall());
        }
        if (!hasJumpPossibility(wall)){
            System.out.println("The cat"+numOfCat+" could not jump over this wall"+wall.getNumOfTheWall());
        }
    }
}
