package level2.lesson2p1;

public abstract class Participants implements Actions {

    protected int heightRestriction;
    protected int runRestriction;
    protected boolean hasOvercomeAnWall = true;
    protected boolean hasOvercomeAnRacetrack = true;

    @Override
    public void run(Racetrack racetrack) {
    }

    @Override
    public void jump(Wall wall) {
    }

    protected boolean hasRunPossibility(Racetrack racetrack) {
        if (runRestriction >= racetrack.getDistanceOfRun()){
            this.hasOvercomeAnRacetrack = true;
            return true;
        }
        else {
            this.hasOvercomeAnRacetrack = false;
            return false;
        }
    }

    protected boolean hasJumpPossibility(Wall wall) {
        if (heightRestriction >= wall.getHeightOfTheWall()){
            this.hasOvercomeAnWall = true;
            return true;
        }
        else {
            this.hasOvercomeAnWall = false;
            return false;
        }
    }
    
    public boolean isPossibleToContinueCompetition(){
        return this.hasOvercomeAnRacetrack && this.hasOvercomeAnWall;
    }

    public  void overcomingOfObstacle(Obstacles[] obstacles) {
        for (int j = 0; j < obstacles.length; j++) {
            overcomingOfRunRoad(obstacles, j);
            overcomingOfWall(obstacles, j);
        }
    }

    public void overcomingOfWall(Obstacles[] obstacles, int j) {
        if ((this.isPossibleToContinueCompetition()) && (obstacles[j] instanceof Wall)) {
            this.jump((Wall) obstacles[j]);
        }
    }

    public void overcomingOfRunRoad(Obstacles[] obstacles, int j) {
        if ((this.isPossibleToContinueCompetition()) && (obstacles[j] instanceof Racetrack)) {
            this.run((Racetrack) obstacles[j]);
        }
    }

    public Participants showParticipant(Participants[] participants) {
        for (Participants participant : participants) {
            if (participant instanceof Cat) {
                return (Cat) this;
            }
            if (participant instanceof Human) {
                return (Human) this;
            }
            if (participant instanceof Robot) {
                return (Robot) this;
            }
        }
        return null;
    }
}
