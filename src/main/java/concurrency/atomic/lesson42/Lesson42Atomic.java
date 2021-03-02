package concurrency.atomic.lesson42;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ljj
 * @version sprint 38
 * @className Lesson42Atomic
 * @description 原子类实现累加线程安全
 * @date 2021-03-01 16:27:45
 */
public class Lesson42Atomic implements Runnable {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Lesson42Atomic lesson42Atomic = new Lesson42Atomic();
        Thread t1 = new Thread(lesson42Atomic);
        Thread t2 = new Thread(lesson42Atomic);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ATOMIC_INTEGER.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            ATOMIC_INTEGER.getAndIncrement();
        }
    }
}
