package concurrency.synchronize;

public class ThisLockDemoTest {
    public static void main(String[] args) throws InterruptedException {
        ThisLockDemo thisLockDemo = new ThisLockDemo();
        Thread t1 = new Thread(thisLockDemo);
        Thread t2 = new Thread(thisLockDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ThisLockDemo.num);
    }
}
