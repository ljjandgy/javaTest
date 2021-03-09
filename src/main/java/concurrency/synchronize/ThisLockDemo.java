package concurrency.synchronize;

/**
 * 通过synchronized关键字实现对象锁
 */
public class ThisLockDemo implements Runnable {
    public static int num = 0;
    @Override
    public void run() {
        for (int i=0;i<1000000;i++){
            increase();
        }
    }
    private synchronized void increase(){
        num++;
    }
}
