package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果用锁保证线程安全，就会有加锁、释放锁的消耗。所以我们可以考虑适用ThreadLocal让线程不安全的对象变为线程私有的，这样就避免了线程安全问题。
 * 相当于是每个线程拥有一个simpleDateFormat对象
 */
public class ThreadLocalDemo06 {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalDemo06().date(finalI);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
}

class ThreadSafeFormatter {
            //ThreadLocal是一个key值，是线程自身拥有的threadLocals的key值。threadLocals是线程自己的对象，不会和其他线程共享。所以通过ThreadLocal获取到的值是属于线程自己的
            public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));
}
