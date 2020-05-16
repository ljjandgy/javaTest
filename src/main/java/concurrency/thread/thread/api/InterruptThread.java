package concurrency.thread.thread.api;

/**
 * 中断线程
 */
public class InterruptThread {
    public static void main(String[] args) {
        //正常中断
        /*Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if (isInterrupted()){
                        System.out.println("我die了");
                        break;
                    }
                }
            }
        };

        t1.start();
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());*/
        //sleep下的中断
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("我die了");
                        break;
                    }
                }
            }
        };

        t1.start();
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        //join下的中断
        /*Thread main = Thread.currentThread();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(100);
                    main.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("我die了");
                }

            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        sleep(100);
                        t1.interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("我die了");
                        break;
                    }
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());*/
    }
}
