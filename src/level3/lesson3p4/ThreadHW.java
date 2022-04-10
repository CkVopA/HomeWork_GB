package level3.lesson3p4;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
2.(доп.) Реализовать задачу из Java 2. Урок 5. с применением ExecutorService. Протестировать скорости. Сделать вывод
*/

public class ThreadHW {
    private static final int SIZE = 10_000_000;
    static float[] arr = new float[SIZE];
    protected static long startTime;
    protected static long endTime;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();

        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < arr.length; i++) {
            int k = i;
                    pool.execute(()-> {
                arr[k] = (float)(arr[k] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
            });
        }


        endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime-startTime) + " ms.");
    }
}
