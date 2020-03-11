package java8.stream.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version V2.0
 * @className NumberStream
 * @description
 * @date 2020-03-11 13:14:30
 */
public class NumberStream {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,34,5,6);
        int count1 = integerList.stream().mapToInt(i->i).sum();
        List<Double> doubleList = Arrays.asList(2.556,2.77,2.987412);
        double count2 = doubleList.stream().mapToDouble(d->d).sum();
        List<Long> longList = Arrays.asList(100000000000000L,1000000000000000000L,2000002123123131L);
        long count3 = longList.stream().mapToLong(l->l).sum();
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        IntStream intStream = integerList.stream().mapToInt(i->i);
        Stream<Integer> integerStream = intStream.boxed();
    }
}
