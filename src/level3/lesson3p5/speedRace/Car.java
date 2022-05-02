package level3.lesson3p5.speedRace;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private final Race race;
    private final int speed;
    private final String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 300));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        for (Stage stage : race.getStages()) {
            stage.go(this);
        }
    }
}