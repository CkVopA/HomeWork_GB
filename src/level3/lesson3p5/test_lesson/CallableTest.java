package level3.lesson3p5.test_lesson;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {9,1,3,4,8,1,5,7};

        ExecutorService exSer1 = Executors.newSingleThreadExecutor();
        ExecutorService exSer2 = Executors.newSingleThreadExecutor();

        System.out.println("ChekPoint 1");
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int resultSum = 0;
                for (int i : arr1) {
                    resultSum += i;
                    System.out.println("t1: "+ i);
                }
                return resultSum;
            }
        };

        Future<Integer> f1 = exSer1.submit(callable);
        exSer1.shutdown();

        System.out.println("ChekPoint 2");
        Future<Integer> f2 = exSer2.submit(()->{
            int resultSum = 0;
            for (int i : arr2) {
                resultSum += i;
                System.out.println("t2: "+ i);
            }
            return resultSum;
        });
        exSer2.shutdown();

        System.out.println("ChekPoint 3");

        System.out.println("Суммы массивов: " + f1.get() + " и " + f2.get());

    }
}
