package level3.lesson3p5.test_lesson;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

    //    testScheduledExecutorService();
    //    testCollections();

    }

    private static void testScheduledExecutorService() {
        ScheduledExecutorService exService = Executors.newScheduledThreadPool(1);

        /*Запускает следующий поток через время (period) если время выполнения блока лямбды было меньше,
                и сразу после завершения блока, если время было дольше чем время (period)*/
        exService.scheduleAtFixedRate(()->{
            System.out.println(new Date() + " START");
            try {
                Thread.sleep(new Random().nextInt(1000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " END");
        },0, 5000, TimeUnit.MILLISECONDS);

        /* Запускает следующий поток через время (period) после окончания выполнения блока лямбды */
        exService.scheduleWithFixedDelay(()->{   //
            System.out.println(new Date() + " START");
            try {
                Thread.sleep(new Random().nextInt(1000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " END");
        },0, 5000, TimeUnit.MILLISECONDS);
    }

    private static void testCollections() {

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
