package concurrency.thread.thread.api;

public class JoinThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           for (int i=0;i<1000;i++){
               System.out.println("我现在处于"+i);
           }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("终于轮到我了");
    }
}
