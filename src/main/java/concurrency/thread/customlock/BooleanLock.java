package concurrency.thread.customlock;

import exception.WaitTimeOutException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ljj
 * @version sprint 21
 * @className BooleanLock
 * @description
 * @date 2020-06-09 19:56:17
 */
public class BooleanLock implements Lock {
    private List<Thread> blockedList = new ArrayList<>();
    /**
     * 如果lockValue为true，说明已经有线程抢占了锁了。为false，则说明锁可用
     */
    private boolean lockValue = false;
    /**
     * 当前获取到锁的线程,用于判断线程是否能释放当前锁
     */
    private Thread currentLockTread;
    @Override
    public synchronized void lock() throws InterruptedException {
        while (lockValue){
            //如果有别人抢占到了锁，那么自己就只能等待
            //把当前线程添加到阻塞队列中
            blockedList.add(Thread.currentThread());
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + "is get lock monitor");
        currentLockTread = Thread.currentThread();
        lockValue = true;
        blockedList.remove(Thread.currentThread());
    }

    @Override
    public synchronized void lock(int mills) throws InterruptedException {
        if (mills<=0){
            lock();
        }
        //需要等待的世界
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + hasRemaining;
        while (lockValue){
            //等待超时，就直接报错退出，防止出现因为一个线程出现死锁，导致所有线程都被block的情况
            if (hasRemaining<=0){
                throw new WaitTimeOutException(Thread.currentThread().getName()+" wait lock time out");
            }
            //如果有别人抢占到了锁，那么自己就只能等待
            //把当前线程添加到阻塞队列中
            blockedList.add(Thread.currentThread());
            this.wait(mills);
            //如果是时间到了醒过来，值一定是小于等于0
            hasRemaining = endTime - System.currentTimeMillis();
        }
        System.out.println(Thread.currentThread().getName() + "is get lock monitor");
        currentLockTread = Thread.currentThread();
        lockValue = true;
        blockedList.remove(Thread.currentThread());
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentLockTread){
            lockValue = false;
            System.out.println(Thread.currentThread().getName() + "is release lock monitor");
            this.notifyAll();
        }
    }

    @Override
    public List<Thread> getBlockedList() {
        return Collections.unmodifiableList(blockedList);
    }

    @Override
    public int getBlockedSize() {
        return blockedList.size();
    }
}
