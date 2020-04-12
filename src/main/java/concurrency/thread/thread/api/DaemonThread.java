package concurrency.thread.thread.api;

import org.junit.Test;

/**
 * 守护线程
 */
public class DaemonThread {
    @Test
    public void test1(){
        Thread t1 = new Thread(()->{
            while (true){
                System.out.println("我还活着");
            }
        },"t1");
        t1.setDaemon(Boolean.TRUE);
        t1.start();

        System.out.println(Thread.currentThread().getName() + "finish.");
    }
}
