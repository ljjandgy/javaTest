package concurrency.future;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过线程池实现带超时的旅游平台（也就是和多个其他接口获取机票价格信息并返回）
 */
public class ThreadPoolDemo {



 ExecutorService threadPool = Executors.newFixedThreadPool(3);



 public static void main(String[] args) throws InterruptedException {

     ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

     System.out.println(threadPoolDemo.getPrices());

 }



 private Set<Integer> getPrices() throws InterruptedException {
//定义线程安全的set
 Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());

 threadPool.submit(new Task(123, prices));

 threadPool.submit(new Task(456, prices));

 threadPool.submit(new Task(789, prices));
//模拟等待3s的同步，过了三秒就返回信息
 Thread.sleep(3000);

 return prices;

 }



 private class Task implements Runnable {



 Integer productId;

 Set<Integer> prices;



 public Task(Integer productId, Set<Integer> prices) {

this.productId = productId;

 this.prices = prices;

 }



 @Override

 public void run() {

 int price=0;

 try {

 Thread.sleep((long) (Math.random() * 4000));

 price= (int) (Math.random() * 4000);

 } catch (InterruptedException e) {

 e.printStackTrace();

 }

 prices.add(price);

 }


    }

}
