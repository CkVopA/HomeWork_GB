package level2.lesson2p1;

public class Robot extends Participants {

    private static int countRobot = 0;

    protected int numOfRobot;

    public int getNumOfRobot() {
        return numOfRobot;
    }

    public Robot (int runRestriction, int heightRestriction) {
        countRobot++;
        this.runRestriction = runRestriction;
        this.heightRestriction = heightRestriction;
        this.numOfRobot = countRobot;
    }

    @Override
    public void run(Racetrack racetrack) {
        if (hasRunPossibility(racetrack)) {
            System.out.println("The robot"+numOfRobot+" has run this distance"+ racetrack.getNumOfTheRacetrack());
        }
        if (!hasRunPossibility(racetrack)){
            System.out.println("The robot"+numOfRobot+" has not run this distance"+ racetrack.getNumOfTheRacetrack());
        }
    }

    @Override
    public void jump(Wall wall) {
        if (hasJumpPossibility(wall)){
            System.out.println("The robot"+numOfRobot+" has jumped over a wall"+wall.getNumOfTheWall());
        }
        if (!hasJumpPossibility(wall)){
            System.out.println("The robot"+numOfRobot+" could not jump over this wall"+wall.getNumOfTheWall());
        }
    }

}
