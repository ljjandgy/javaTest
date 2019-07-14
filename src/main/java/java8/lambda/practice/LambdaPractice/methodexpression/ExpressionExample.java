package java8.lambda.practice.LambdaPractice.methodexpression;

import java8.lambda.base.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ExpressionExample {
    public static void main(String[] arg){
        getName(new Apple("test","green",800),Apple::getName);
        List<String> list = Arrays.asList("test1","test3","test4","test2");
        compare(list,String::compareToIgnoreCase);
        list.forEach(System.out::println);
    }

    private static  <T,R> void getName(T t, Function<T,R> function){
        System.out.println(function.apply(t));
    }

    private static <T>void compare(List<T> list, Comparator<T> comparator){
        list.sort(comparator);
    }

}
