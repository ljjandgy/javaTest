package concurrency.thread.base;

import org.junit.Test;

public class ThreadConstructionMethodTest {
    @Test
    public void noArgTest(){
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
