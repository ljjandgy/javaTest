package concurrency.threadgroup;

import java.util.stream.Stream;

public class ThreadGroupCreateDemo {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg1, () -> {
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        ThreadGroup tg2 = new ThreadGroup(tg1,"tg2");
        Thread t2 = new Thread(tg2,()->{
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t2.start();

        System.out.println(tg1.activeCount());
        System.out.println(tg2.activeCount());
        System.out.println(tg1.activeGroupCount());
        Thread[] tg1Array = new Thread[tg1.activeCount()];
        tg1.enumerate(tg1Array);
        //输出当前线程组及子线程组的活动线程信息
        Stream.of(tg1Array).forEach(System.out::println);
        //输出tg活动线程信息
        Thread[] tg1NewArray = new Thread[tg1.activeCount()];
        tg1.enumerate(tg1NewArray,false);
        Stream.of(tg1NewArray).forEach(System.out::println);

    }
}
