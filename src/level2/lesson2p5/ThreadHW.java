package level2.lesson2p5;

import java.util.Arrays;

public class ThreadHW {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE/2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    protected static void firstMethod() {
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)
                    (arr[i] * Math.sin(0.2f + i/5) *  Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println();
    }

    protected static void  secondMethod(){
        Arrays.fill(arr, 1.0f);
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];
        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < leftHalf.length; i++) {
                arr[i] = (float)(arr[i] *
                        Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }

        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < rightHalf.length; i++) {
                arr[i] = (float)(arr[i] *
                        Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] aR2 = new float[SIZE];
        System.arraycopy(leftHalf, 0, aR2, 0, leftHalf.length);
        System.arraycopy(rightHalf, 0, aR2, leftHalf.length, rightHalf.length);

        System.out.println("Time in threads: " + (System.currentTimeMillis() - startTime) + " ms." );
    }
}
