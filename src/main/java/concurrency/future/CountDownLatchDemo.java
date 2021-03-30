package concurrency.future;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 上一个基本线程池的方法需要固定等待3s才能返回信息。如果接口返回的很快，还是需要等待3s。
 * 所以这个例子在线程池处理的基础上加上了一个计数器。基础等待时间还是3s，如果任务提前完成，也能提前返回
 */
public class CountDownLatchDemo {

          ExecutorService threadPool = Executors.newFixedThreadPool(3);

          public static void main(String[] args) throws InterruptedException {
              CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
              System.out.println(countDownLatchDemo.getPrices());
          }



          private Set<Integer> getPrices() throws InterruptedException {
              Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
              CountDownLatch countDownLatch = new CountDownLatch(3);

              threadPool.submit(new Task(123, prices, countDownLatch));
              threadPool.submit(new Task(456, prices, countDownLatch));
              threadPool.submit(new Task(789, prices, countDownLatch));
              //计数器等待并计数，相当于运行任务提前结束。不过缺点是必须提前设置好需要任务数。并且需要自己对任务进行计数
              countDownLatch.await(3, TimeUnit.SECONDS);
              return prices;

          }



          private class Task implements Runnable {



          Integer productId;

          Set<Integer> prices;

          CountDownLatch countDownLatch;



          public Task(Integer productId, Set<Integer> prices,

          CountDownLatch countDownLatch) {
              this.productId = productId;
              this.prices = prices;
              this.countDownLatch = countDownLatch;
          }

          @Override
          public void run() {
              int price = 0;
              try {
                  Thread.sleep((long) (Math.random() * 4000));
                  price = (int) (Math.random() * 4000);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  prices.add(price);
                  countDownLatch.countDown();
          }
          }

        }

