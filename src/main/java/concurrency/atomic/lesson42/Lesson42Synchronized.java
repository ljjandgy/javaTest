package concurrency.atomic.lesson42;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ljj
 * @version sprint 38
 * @className Lesson42Atomic
 * @description synchronized实现累加线程安全
 * @date 2021-03-01 16:27:45
 */
public class Lesson42Synchronized implements Runnable {
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Lesson42Synchronized lesson42Atomic = new Lesson42Synchronized();
        Thread t1 = new Thread(lesson42Atomic);
        Thread t2 = new Thread(lesson42Atomic);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(num);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            synchronized (this) {
                ++num;
            }
        }
    }
}
