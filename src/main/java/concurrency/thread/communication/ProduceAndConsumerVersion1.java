package concurrency.thread.communication;

/**
 * @author ljj
 * @version sprint 19
 * @className ProduceAndConsumerVersion1
 * @description 生产者消费者版本1---用于使用wait和notify
 * @date 2020-04-27 20:57:37
 */
public class ProduceAndConsumerVersion1 {
    private int i = 1;

    private volatile boolean isProduced = false;

    private final Object LOCK = new Object();

    private void produce(){
        synchronized (LOCK){
            if (isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                System.out.println("生产完毕"+i);
                isProduced = true;
                LOCK.notify();
            }
        }
    }

    private void consume(){
        synchronized (LOCK){
            if (isProduced){
                System.out.println("开始消费"+i);
                isProduced = false;
                LOCK.notify();
            }else{
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceAndConsumerVersion1 version1 = new ProduceAndConsumerVersion1();
        new Thread(()->{
            for (int j = 0; j < 100000; j++) {
                version1.produce();
            }
        },"producer").start();
        new Thread(()->{
            for (int k = 0; k < 100000; k++) {
                version1.consume();
            }
        },"comsumer").start();
    }
}
