package concurrency.thread.customlock;

import java.util.List;

/**
 * @author ljj
 * @version sprint 21
 * @className Lock
 * @description
 * @date 2020-06-09 19:56:26
 */
public interface Lock {
    /**
     * 给线程加锁
     */
    void lock() throws InterruptedException;

    /**
     * 锁指定时间
     * @param mills 锁的时间/秒
     */
    void lock(int mills) throws InterruptedException;

    /**
     * 解锁
     */
    void unlock();

    /**
     * 获取正在等待锁的线程对象
     */
    List<Thread> getBlockedList();

    /**
     * 获取阻塞的线程数量
     * @return 阻塞的线程数
     */
    int getBlockedSize();


}
