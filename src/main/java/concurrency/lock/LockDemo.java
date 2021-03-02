package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljj
 * @version sprint 37
 * @className LockDemo
 * @description
 * @date 2021-01-27 12:09:17
 */
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }
}
