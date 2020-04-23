package concurrency.thread.lock;

/**
 * @author ljj
 * @version sprint 19
 * @className SynchronizeThisTest1
 * @description
 * @date 2020-04-23 19:29:31
 */
public class SynchronizeThisTest1 {
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(()->{
            lockTest.method1();
        },"t1").start();
        new Thread(()->{
            lockTest.method2();
        },"t2").start();
    }

    static class LockTest{
        //自定义锁对象
        Object LOCK = new Object();
        void method1(){
            synchronized (LOCK){
                try {
                    System.out.println(Thread.currentThread().getName()+"开始执行");
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        synchronized void method2(){
            try {
                System.out.println(Thread.currentThread().getName()+"开始执行");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
