package level3.lesson3p5.test_lesson;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {
    public static void main(String[] args) throws InterruptedException {

    //    semaphoreTest();
    //    countDownLatchTest();
    //    cyclicBarrierTest();

        lockTest();


    }

    private static void semaphoreTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 15; i++) {
            executorService.execute(()-> {
                try {
                    semaphore.acquire();
                    System.out.println("Start " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("END " +Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();
    }

    private static void countDownLatchTest() throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(10);  // ставит счётчик на указанное число

        for (int i = 0; i < 15; i++) {
           new Thread(()->{
               System.out.println("START " + Thread.currentThread().getName());
               try {
                Thread.sleep(new Random().nextInt(4000) + 2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {
                   cdl.countDown();                                      // уменьшает счётчик -1
                   System.out.println("END " + Thread.currentThread().getName());
               }
           }).start();
        }

        cdl.await();                    // блокирует исполнение последующего кода пока счётчик не станет равным 0

        System.out.println("END");
    }

    private static void cyclicBarrierTest() throws InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(5);   // N потоков = 5

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            new Thread(()->{
                try {
                    System.out.println("START " + Thread.currentThread().getName());
                    Thread.sleep(new Random().nextInt(5000) + 2000);
                    cb.await();   // блокирует исполнение следующего кода пока не будут готовы N потоков,
                                    //   затем все N потоков продолжают работу ОДНОВРЕМЕННО.

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("END " + Thread.currentThread().getName());
                }
            }).start();
        }
    }

    private static void lockTest() {

        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(()->{
            reentrantLock.lock();          // блокирует исполнение других потоков пока этот рентрант закрыт
            try {
                System.out.println("START - " + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(1000) + 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("END - " + Thread.currentThread().getName());
                reentrantLock.unlock();         // открывает рентрант - могут запускаться другие потоки
            }
        }).start();

        new Thread(()->{
            reentrantLock.lock();
            try {
                System.out.println("START - " + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(1000) + 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("END - " + Thread.currentThread().getName());
                reentrantLock.unlock();
            }
        }).start();

        // reentrantLock раз в 10 медленнее, чем обычный блок синхронизации

            /*Есть полезный     ReentrantReadWriteLock      для записи и чтения файлов.

        когда на изменение файла может захватить толького один писатель, при этом, все остальные писатели
        и читатели блокируются. Когда писатель отключается - рандомно могут захватить файл как писатели
        так и читатели. Если файл захватывает один из читателей, то файл становится доступным для чтения
        и для других читателей.*/
    }

}
