package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建10个线程，每个线程都拥有自己的simpleDateFormat，因此在格式化的时候能正常格式化
 */
public class ThreadLocalDemo02 {
    public  static  void  main(String[]  args)  throws  InterruptedException  {
                for  (int  i  =  0;  i  <  10;  i++)  {
                        int  finalI  =  i;
                        new  Thread(()  ->  {
                                String  date  =  new  ThreadLocalDemo02().date(finalI);
                                System.out.println(date);
                        }).start();
                        Thread.sleep(100);
                }
        }

        public  String  date(int  seconds)  {
                Date date  =  new  Date(1000  *  seconds);
                SimpleDateFormat simpleDateFormat  =  new  SimpleDateFormat("mm:ss");
                return  simpleDateFormat.format(date);
        }
}
