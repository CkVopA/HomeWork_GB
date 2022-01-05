package level2.lesson2p1;

public class Racetrack extends  Obstacles {

    private final int distanceOfRun;
    private final int numOfTheRacetrack;
    static int countTheRacetrack = 0;

    public int getNumOfTheRacetrack() {
        return numOfTheRacetrack;
    }

    public int getDistanceOfRun() {
        return distanceOfRun;
    }

    public Racetrack(int distanceOfRun) {
        countTheRacetrack++;
        this.distanceOfRun = distanceOfRun;
        this.numOfTheRacetrack = countTheRacetrack;
    }
}
