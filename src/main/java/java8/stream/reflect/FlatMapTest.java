package java8.stream.reflect;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    @Test
    public void test(){
        //flatMap 把多个流扁平化为一个流,常用于合并流
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> charList =  streamOfwords.map(word->word.split(""))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList());
        charList.forEach(System.out::println);
    }
}
