package level3.lesson3p5.speedRace;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public static int getCarsCount() {
        return CARS_COUNT;
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

            for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
            }

    }
}