package level3.lesson3p4;

/*
1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
        Используйте wait/notify/notifyAll.

2.(доп.) Реализовать задачу из Java 2. Урок 5. с применением ExecutorService. Протестировать скорости. Сделать вывод
*/

import level1.lesson1p2.Main;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CleverThread implements Runnable{

    private final String letter;
    private final MainCleverThread lock;
    private final int p;

    public CleverThread(String letter, MainCleverThread lock, int p) {
        this.letter = letter;
        this.lock = lock;
        this.p = p;
    }

    @Override
    public void run() {

        while(lock.status < 13) {
            synchronized (lock) {

                while(!((lock.status % 3) == 0) && p == 1){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((lock.status % 3) == 1) && p == 2){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((lock.status % 3) == 2) && p == 3){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(letter);
                lock.status++;
//                if ((lock.status % 3) == 0) System.out.print("-");
                lock.notifyAll();
            }
        }
    }

    /*  volatile String LET = "";
    public synchronized void showLetter(String letter) {
        if (LET.equals(letter)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(letter);
        LET = letter;
        notifyAll();
    }*/
}

class MainCleverThread {

    volatile int status = 0;

    public static void main(String[] args) {
        MainCleverThread lock = new MainCleverThread();

        Thread t1 = new Thread(new CleverThread("A", lock, 1));
        Thread t2 = new Thread(new CleverThread("B", lock, 2));
        Thread t3 = new Thread(new CleverThread("C", lock, 3));
        t1.start();
        t2.start();
        t3.start();




        /*CleverThread cl = new CleverThread();


            Thread t1 = new Thread(()-> {
                for (int i = 0; i < 5; i++) {
                    cl. showLetter("A");
                }
            });

            Thread t2 = new Thread(()-> {
                for (int i = 0; i < 5; i++) {
                    cl. showLetter("B");
                }
            });

            Thread t3 = new Thread(()-> {
                for (int i = 0; i < 5; i++) {
                    cl. showLetter("C");
                }
            });

            t1.start();
            t2.start();
            t3.start();*/

/*        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName() + " - A");

                System.out.println(Thread.currentThread().getName() + " - B");

                System.out.println(Thread.currentThread().getName() + " - C");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }*/
    }
}

