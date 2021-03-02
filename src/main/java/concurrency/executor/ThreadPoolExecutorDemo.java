package concurrency.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ljj
 * @version sprint 36
 * @className ThreadPoolExecutorDemo
 * @description
 * @date 2021-01-25 17:58:47
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(15, 25, 15, TimeUnit.MINUTES, new SynchronousQueue<Runnable>(), r -> new Thread(r, "thread" + Thread.currentThread().getId()));
        threadPoolExecutor.submit(()->System.out.print("test"));
    }
}
