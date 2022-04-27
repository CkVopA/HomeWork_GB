package level3.lesson3p5.speedRace;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        preparing(race, cars);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        reversCount(3);

        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        ExecutorService exec = Executors.newFixedThreadPool(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            //new Thread(cars[i]).start();
            int k = i;
            exec.execute(() -> {
              //  try {
                    cars[k].run();
              //  } finally {
                    countDownLatch.countDown();
              //  }
            });
        }
        countDownLatch.await();
        exec.shutdown();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    private static void preparing(Race race, Car[] cars) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(1);
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);

        new Thread(() -> {
            ExecutorService pool = Executors.newFixedThreadPool(CARS_COUNT);
            for (int i = 0; i < cars.length; i++) {
                int k = i;
                pool.execute(() -> {
                    cars[k] = new Car(race, 20 + (int) (Math.random() * 10));
                    countDownLatch.countDown();
                });
            }
            pool.shutdown();
        }).start();

        countDownLatch.await();
        cb.await();
    }

    private static void reversCount(int n) throws InterruptedException {
        int count = n;
        while (count >= 1) {
            System.out.println(">" + count + "<");
            Thread.sleep(1000);
            count--;
        }
        System.out.println("START!!!");
    }
}

