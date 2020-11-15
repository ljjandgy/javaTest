package concurrency.thread.thread.exception;

/**
 * 捕获线程中抛出的未知异常
 */
public class CatchExceptionDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int a = 3/0;

        });
        /**
         * 主要用于处理非受检异常
         */
        t1.setUncaughtExceptionHandler((t,e)->{
            System.out.println(e.getMessage());
        });
        t1.start();

    }
}