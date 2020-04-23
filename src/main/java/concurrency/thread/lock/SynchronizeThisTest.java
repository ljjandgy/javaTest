package concurrency.thread.lock;

/**
 * @author ljj
 * @version sprint 19
 * @className SynchronizeThisTest
 * @description this锁测试（synchronized锁默认是this锁，也就是一个实例中的所有synchronized锁对象都是同一个）
 * @date 2020-04-23 19:23:20
 */
public class SynchronizeThisTest {
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
         LockTest(){}

         synchronized void method1(){
            try {
                System.out.println(Thread.currentThread().getName()+"开始执行");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
