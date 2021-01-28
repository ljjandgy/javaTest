package concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ljj
 * @version sprint 37
 * @className CachedData
 * @description 读写锁的降级操作demo
 * @date 2021-01-28 19:25:00
 */
public class CachedData {
    Object data;
    /** 用于判断缓存是否被其他线程修改过了 **/
    volatile boolean cacheValid;

    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 采用锁降级的方式获取对象
     * 所谓降级，就是从写锁降级为读锁，通常发生在自己对资源修改后
     */
    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            //在获取写锁之前，必须首先释放读锁。
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                //这里需要再次判断数据的有效性,因为在我们释放读锁和获取写锁的空隙之内，可能有其他线程修改了数据。
                if (!cacheValid) {
                    data = new Object();
                    cacheValid = true;
                }
                //在不释放写锁的情况下，直接获取读锁，这就是读写锁的降级。
                rwl.readLock().lock();
            } finally {
                //释放了写锁，但是依然持有读锁，保持读锁的原因是因为我们要获取缓存，也就是object的信息，有了读锁才能保证对象知道我们获取完毕都不会被修改。
                rwl.writeLock().unlock();
            }
        }
        try {
            System.out.println(data);
        } finally {
            //释放读锁
            rwl.readLock().unlock();
        }
    }

}

