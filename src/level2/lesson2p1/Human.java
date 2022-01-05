package level2.lesson2p1;

public class Human extends Participants {

    private static int countHuman = 0;

    protected int numOfHuman;

    public int getNumOfHuman() {
        return numOfHuman;
    }

    public Human (int runRestriction, int heightRestriction) {
        countHuman++;
        this.runRestriction = runRestriction;
        this.heightRestriction = heightRestriction;
        this.numOfHuman = countHuman;
    }

    @Override
    public void run(Racetrack racetrack) {
        if (hasRunPossibility(racetrack)) {
            System.out.println("The human"+numOfHuman+" has not run this distance" + racetrack.getNumOfTheRacetrack());
        }
        if (!hasRunPossibility(racetrack)){
            System.out.println("The human"+numOfHuman+" has run this distance"+ racetrack.getNumOfTheRacetrack());
        }
    }

    @Override
    public void jump(Wall wall) {
        if (hasJumpPossibility(wall)){
            System.out.println("The human"+numOfHuman+" has jumped over a wall"+wall.getNumOfTheWall());
        }
        if (!hasJumpPossibility(wall)){
            System.out.println("The human"+numOfHuman+" could not jump over this wall"+wall.getNumOfTheWall());
        }
    }

}
