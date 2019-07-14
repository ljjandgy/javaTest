package java8.lambda.practice.LambdaPractice.methodexpression;

import java8.lambda.base.Apple;

import java.util.function.Function;

public class ExpressionExample {
    public static void main(String[] arg){
        getName(new Apple("test","green",800),Apple::getName);
    }

    private static  <T,R> void getName(T t, Function<T,R> function){
        System.out.println(function.apply(t));
    }
}
