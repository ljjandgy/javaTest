package threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] arg){
        ExecutorService executor1 = Executors.newCachedThreadPool();//带缓存功能的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);//可以指定缓存线程数目的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();//只能一个活动线程的线程池，队列中所有任务是顺序执行的
        //针对定时/周期性任务的线程池，获得的是ScheduledExecutorService
        ExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();//单一可用线程
        ExecutorService executorService2 = Executors.newScheduledThreadPool(5);//多个可用线程
        ExecutorService executorService3 = Executors.newWorkStealingPool();//java8新增的线程池
    }
}
