package java8.stream.collectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ljj
 * @version V2.0
 * @className ReducedTest
 * @description
 * @date 2020-03-19 13:13:55
 */
public class ReducedTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a","b","c","d","e","f","g");
        long count = stringList.stream().count();
        long count1 = stringList.stream().collect(Collectors.counting());
        //计算流中的元素个数
        System.out.println(count);
        System.out.println(count1);
        //通过收集器获得最大值
        Optional<String> max = stringList.stream().collect(Collectors.maxBy((String o1, String o2)->o1.compareTo(o2)));
        max.ifPresent(System.out::println);
        //通过收集器获得最小值
        Optional<String> min = stringList.stream().collect(Collectors.minBy((String o1, String o2)->o1.compareTo(o2)));
        min.ifPresent(System.out::println);

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,6,7,8,45,3,12,3);
        long sum = intList.stream().collect(Collectors.summingLong(a->a));
        System.out.println(sum);
        double average = intList.stream().collect(Collectors.averagingInt(a->a));
        System.out.println(average);
        System.out.println(sum / intList.stream().count());
        IntSummaryStatistics summaryStatistics = intList.stream().collect(Collectors.summarizingInt(a->a));
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getSum());

        String joinStr = stringList.stream().collect(Collectors.joining());
        System.out.println(joinStr);
        String joinStr1 = stringList.stream().collect(Collectors.joining(","));
        System.out.println(joinStr1);
        int reducingSum = intList.stream().collect(Collectors.reducing(0,i->i,(i,j)->i+j));
        System.out.println(reducingSum);
        long reducingCount = intList.stream().collect(Collectors.reducing(0L,a->1L,Long::sum));
        System.out.println(reducingCount);
    }
}
