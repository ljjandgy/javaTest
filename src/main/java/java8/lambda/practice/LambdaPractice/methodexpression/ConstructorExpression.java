package java8.lambda.practice.LambdaPractice.methodexpression;

import java8.lambda.base.Apple;

import java.util.function.Supplier;

/**
 * 构造方法方法引用
 */
public class ConstructorExpression {
    public static void main(String[] arg){
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
    }


}
