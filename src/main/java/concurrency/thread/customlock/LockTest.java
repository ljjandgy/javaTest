package concurrency.thread.customlock;

import exception.WaitTimeOutException;

import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 21
 * @className LockTest
 * @description
 * @date 2020-06-09 20:39:56
 */
public class LockTest {
    public static void main(String[] args) {
        BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1","T2","T3","T4").forEach(name->new Thread(()->{
            try {
                booleanLock.lock();
                work();
                System.out.println(Thread.currentThread().getName() + "is get the lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (WaitTimeOutException e){
                System.out.println(e.getMessage());
            }
            finally {
                booleanLock.unlock();
            }
        },name).start());
    }

    private static void work() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "is working");
        Thread.sleep(10_000);
    }
}
