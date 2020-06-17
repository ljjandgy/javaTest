package concurrency.thread.customlock;

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
    @Override
    public void lock() throws InterruptedException {
        lock(0);
    }

    @Override
    public synchronized void lock(int mills) throws InterruptedException {
        if (mills<=0){
            mills = 0;
        }
        while (lockValue){
            //如果有别人抢占到了锁，那么自己就只能等待
            //把当前线程添加到阻塞队列中
            blockedList.add(Thread.currentThread());
            this.wait(mills);
        }
        System.out.println(Thread.currentThread().getName() + "is get lock monitor");
        lockValue = true;
        blockedList.remove(Thread.currentThread());
    }

    @Override
    public synchronized void unlock() {
        lockValue = false;
        System.out.println(Thread.currentThread().getName() + "is release lock monitor");
        this.notifyAll();
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
