package concurrency.thread.strategy;

import java.util.Random;

public class ThreadStrategy {
    public static void main(String[] args) {
        Runnable runnable1 = ()->{
            System.out.println("需要缴税："+1500);
        };
        Runnable runnable2 = ()->{
            System.out.println("需要缴税" + 1600);
        };
        Thread thread;
        int salary = new Random().nextInt(25000);
        System.out.println(salary);
        if (salary>10000){
            thread = new Thread(runnable1,"strategyTest2");
        }else {
            thread = new Thread(runnable2,"strategyTest1");
        }
        thread.start();
    }
}
