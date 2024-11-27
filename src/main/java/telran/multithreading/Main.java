package telran.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Worker worker1 = new Worker(lock1, lock2);
        Worker worker2 = new Worker(lock1, lock2);

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}