package concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ljj
 * @version sprint 38
 * @className AtomicLongDemo
 * @description
 * @date 2021-02-24 20:29:16
 */
public class AtomicLongDemo {
    public  static  void  main(String[]  args)  throws  InterruptedException  {
        AtomicLong counter  =  new  AtomicLong(0);
        ExecutorService service  =  Executors.newFixedThreadPool(16);
        for (int  i  =  0;  i  <  100;  i++)  {
            service.submit(new  Task(counter));
        }

        Thread.sleep(2000);
        System.out.println(counter.get());
    }

    static  class  Task  implements  Runnable  {

        private  final  AtomicLong  counter;

        public  Task(AtomicLong  counter)  {
            this.counter  =  counter;
        }

        @Override
        public  void  run()  {
            counter.incrementAndGet();
        }
    }
}
