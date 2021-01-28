package concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ljj
 * @version sprint 37
 * @className ReadLockJumpQueue
 * @description 演示读锁不能插写锁的队的情况
 * @date 2021-01-28 19:13:44
 */
public class ReadLockJumpQueue {
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock
                                                                    .readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock
                                                                      .writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //之所以是看起来顺序执行的，是因为有锁而且没有其他线程进行竞争，所以才有序。
        //可以看到线程5没有抢到锁，在线程三的写锁释放之前，所以可以确定ReentrantReadWriteLock采用的非公平策略是读锁不能插写锁的队。
        new Thread(() -> read(), "Thread-2").start();
        new Thread(() -> read(), "Thread-4").start();
        new Thread(() -> write(), "Thread-3").start();
        new Thread(() -> read(), "Thread-5").start();
    }
}
