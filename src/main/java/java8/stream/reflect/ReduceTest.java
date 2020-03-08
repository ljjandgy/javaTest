package java8.stream.reflect;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String[] args) {
        //求和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        int count = list.stream().reduce(0,(a,b)->a+b);
        System.out.println(count);
        //求乘积
        count = list.stream().reduce(1,(a,b)->a*b);
        System.out.println(count);
        //求最大值
        Optional<Integer> max = list.stream().reduce(Integer::max);
        max.ifPresent(System.out::println);
        //求最小值
        Optional<Integer> min = list.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);
    }
}
