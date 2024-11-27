package telran.multithreading;

import java.util.concurrent.locks.Lock;

public class Worker extends Thread {
    private final Lock lock1;
    private final Lock lock2;

    public Worker(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void f1() {
        lock1.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println();
        lock2.unlock();
        lock1.unlock();
    }

    public void f2() {
        lock2.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        System.out.println();
        lock1.unlock();
        lock2.unlock();
    }

    @Override
    public void run() {
        f1();
        f2();
    }
}