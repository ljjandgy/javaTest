package java8.lambda.practice.LambdaPractice.newfunctioninterface;

import java8.lambda.base.Apple;
import java8.lambda.base.Orange;

/**
 * 函数式接口Consumer的使用实例,该接口是用于访问并操作带个对象
 */
public class Consumer {
    public static void main(String[] arg){
        Apple apple = new Apple("大苹果","red",500);
        Orange orange = new Orange("大橘子","green",500);
        getProperties((Apple apple1)->System.out.println(apple.getName()),apple);
        getProperties((Orange orange1)->System.out.println(orange.getName()),orange);
    }

    /**
     * 获取对象名称
     */
    public static <T>void getProperties(java.util.function.Consumer<T> consumer,T obj){
        //直接访问对象，并获取对象的某个属性，具体如何去获取就由
        consumer.accept(obj);
    }
}
