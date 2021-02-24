package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ljj
 * @version sprint 38
 * @className BaseTestDemo
 * @description
 * @date 2021-02-24 14:28:00
 */
public class BaseTestDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.addAndGet(5));
    }
}
