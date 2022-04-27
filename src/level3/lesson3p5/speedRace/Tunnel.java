package level3.lesson3p5.speedRace;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    private static Semaphore semaphore = new Semaphore(2);

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description + " * * *");
                semaphore.acquire();

                System.out.println(c.getName() + " начал этап: " + description + " + + + + + + + + + + + + + + + + + +");
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(c.getName() + " закончил этап: " + description + " _-_-_ _-_-_ _-_-_ _-_-_ _-_-_ _-_-_");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
