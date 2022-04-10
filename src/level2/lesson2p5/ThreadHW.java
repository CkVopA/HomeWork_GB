package level2.lesson2p5;

import java.util.Arrays;

public class ThreadHW {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }
// Заполнение большого массивазначениями по формуле и подсчёт полного времени
    protected static void firstMethod() {
        System.out.println("First method start:");
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)
                    (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println();
    }
// Одновременное заполнение двух половинок большого массива в двух потоках и подсчёт времени
    protected static void secondMethod() {
        System.out.println("Second method start:");
        Arrays.fill(arr, 1.0f);
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];
        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);

        Thread motherThread = new Thread(() -> {
            System.out.println("This is incredible mother's thread!");

            Thread thread1 = new Thread(() -> {
                System.out.println("First thread is move");
                for (int i = 0; i < leftHalf.length; i++) {
                    if (i == leftHalf.length-1){
                        System.out.println("First thread is done.");
                    }
                    arr[i] = (float) (arr[i] *
                            Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            });
            Thread thread2 = new Thread(() -> {
                System.out.println("Second thread is move");
                for (int i = 0; i < rightHalf.length; i++) {
                    if (i == rightHalf.length-1){
                        System.out.println("Second thread is done.");
                    }
                    arr[i] = (float) (arr[i] *
                            Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            });

            try {
                thread1.start();
                thread2.start();
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            motherThread.start();
            motherThread.join();
            System.out.println("Mother's thread is done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] aR2 = new float[SIZE];
        System.arraycopy(leftHalf, 0, aR2, 0, leftHalf.length);
        System.arraycopy(rightHalf, 0, aR2, leftHalf.length, rightHalf.length);

        System.out.println("Calculation completed in " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
