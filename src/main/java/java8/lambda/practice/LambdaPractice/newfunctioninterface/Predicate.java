package java8.lambda.practice.LambdaPractice.newfunctioninterface;

import java8.lambda.base.Apple;
import java8.lambda.base.Orange;

/**
 * 关于新函数式接口predicate的应用--用于比较，也可以用于优化比较相关的环绕执行模式
 */
public class Predicate {
    public static void main(String[] arg){
        test((Apple apple)->apple.getWeight() >500,new Apple("大大大苹果","black",800));
        test((Orange orange)->orange.getWeight() >600,new Orange("大橘子","red",900));

    }

    /**
     * 通用比较方法，返回值前面的类型表示这个方法将会接受什么类型的参数
     * @param predicate 比较行为--函数式接口实现行为参数化
     * @param obj
     * @param <T>
     * @return
     */
    public static <T>void test(java.util.function.Predicate<T> predicate,T obj){
        //通常来说这个地方会有一些通用代码，或者说是环绕执行模式的代码
        if (predicate.test(obj)){
            System.out.println("这是一个大家伙");
        }
    }
}
