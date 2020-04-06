package concurrency.thread.bank;

/**
 * 多线程实现银行叫号系统
 */
public class BankCodeSystem {
    private static int nowNum = 1;

    private static final int allNum = 1000;

    public static void main(String[] args) {
        Runnable callNumMethod = () -> {
            while (nowNum<=allNum){
                System.out.println(Thread.currentThread().getName() + "叫的号为：" + nowNum++);
            }
        };
        Thread call1 = new Thread(callNumMethod, "一号柜台");
        Thread call2 = new Thread(callNumMethod,"二号柜台");
        Thread call3 = new Thread(callNumMethod,"三号柜台");
        call1.start();
        call2.start();
        call3.start();
    }
}

