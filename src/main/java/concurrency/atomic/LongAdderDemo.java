package concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ljj
 * @version sprint 38
 * @className LongAdderDemo
 * @description 长整型加法器实践
 * @date 2021-02-25 10:31:26
 */
public class LongAdderDemo {
    public  static  void  main(String[]  args)  throws  InterruptedException  {
        LongAdder counter  =  new  LongAdder();
        ExecutorService service  =  Executors.newFixedThreadPool(16);
        for (int  i  =  0;  i  <  100;  i++)  {
            service.submit(new  Task(counter));
        }
        Thread.sleep(2000);
        System.out.println(counter.sum());
        service.shutdown();
    }

    static  class  Task  implements  Runnable  {
        private  final  LongAdder  counter;
        public  Task(LongAdder  counter)  {
            this.counter  =  counter;
        }
        @Override
        public  void  run()  {
            counter.increment();
        }
    }
}
