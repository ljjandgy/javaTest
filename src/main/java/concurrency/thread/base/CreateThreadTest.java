package concurrency.thread.base;

import org.junit.Test;

public class CreateThreadTest {
    @Test
    public void test(){
        //通过thread创建线程
        Thread t1 = new Thread("testThread"){
            @Override
            public void run(){
                //输出线程名称
                System.out.println(Thread.currentThread().getName());
                System.out.println("work over");
            }
        };
        t1.start();
        //通过runnable创建线程
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                //输出线程名称
                System.out.println(Thread.currentThread().getName());
                System.out.println("work over");
            }
        };
        Thread t2 = new Thread(r1,"testThread1");
        t2.start();
    }
}
