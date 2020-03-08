package java8.stream.reflect;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindTest {
    @Test
    public void test(){
        List<String> list = Arrays.asList("aaa","bbba","ccca","ddda");
        //查找第一个包含a的字符串
        Optional<String> findString = list.stream().filter(str->str.contains("a")).findFirst();
        findString.ifPresent(System.out::println);
    }
}
