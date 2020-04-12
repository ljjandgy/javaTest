package concurrency.thread.thread.api;

import java.util.stream.IntStream;

public class ThreadIdAndPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            IntStream.range(0,100).forEach(i->System.out.println(Thread.currentThread().getName()+"第"+i+"次"));
        },"t1");
        System.out.println(t1.getId());
        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(()->{
            IntStream.range(0,100).forEach(i->System.out.println(Thread.currentThread().getName()+"第"+i+"次"));
        },"t2");
        System.out.println(t2.getId());
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(()->{
            IntStream.range(0,100).forEach(i->System.out.println(Thread.currentThread().getName()+"第"+i+"次"));
        },"t3");
        System.out.println(t3.getId());
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
