package level3.lesson3p5.speedRace;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        preparingForRacing(race, cars);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        reversCountForStart();

        startRacing(cars);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    private static synchronized void preparingForRacing(Race race, Car[] cars) throws InterruptedException, BrokenBarrierException {
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

        countDownLatch.await(); // ожидание завершения каждого потока создания машины
        cb.await();  // ожидание окончания безымянного потока Thread
    }

    private static void reversCountForStart() throws InterruptedException {
        int count = 1;
        while (count > 0) {
            System.out.print(">" + count + "<   ");
            Thread.sleep(1000);
            count--;
        }
        System.out.println();
        System.out.println("START!!!");
    }

    private static void startRacing(Car[] cars) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        ExecutorService exec = Executors.newFixedThreadPool(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            int k = i;
            exec.execute(() -> {
                cars[k].run();
                countDownLatch.countDown();

                if (countDownLatch.getCount() == CARS_COUNT-1){
                    System.out.println(cars[k].getName()+" is WINNER");
                }
                Thread.yield();
            });
        }
        countDownLatch.await();
        exec.shutdown();
    }
}