package concurrency.thread.lock;

/**
 * @author ljj
 * @version sprint 19
 * @className SynchronizeStaticTest
 * @description
 * @date 2020-04-23 19:55:15
 */
public class SynchronizeStaticTest {
    public static void main(String[] args) {
        StaticLockTest staticLockTest = new StaticLockTest();
        new Thread(()->{
            staticLockTest.method1();
        },"t1").start();

        new Thread(()->{
            StaticLockTest.method2();
        },"t2").start();

        new Thread(()->{
            staticLockTest.method3();
        },"t3").start();
    }

    static class StaticLockTest{
        static {
            //类级别的锁和this级别的锁不会互相影响
            synchronized (StaticLockTest.class){
                try {
                    System.out.println("sttaic lock on");
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void method1(){
            synchronized (StaticLockTest.class){
                try {
                    System.out.println(Thread.currentThread().getName()+"do this");
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized static void method2(){
            try {
                System.out.println(Thread.currentThread().getName()+"do this");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void method3(){
            try {
                System.out.println(Thread.currentThread().getName()+"do this");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
