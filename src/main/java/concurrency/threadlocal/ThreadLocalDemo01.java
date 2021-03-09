package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个线程，分别自己创建simpleDateFormat，然后进行时间的格式化
 * 
 */
public class ThreadLocalDemo01 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            String date = new ThreadLocalDemo01().date(1);
            System.out.println(date);
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            String date = new ThreadLocalDemo01().date(2);
            System.out.println(date);
        }).start();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(date);
    }
}
