package java8.stream.reflect;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class MatchTest {
    public static void main(String[] args) {
        //anyMatch
        List<String> list = Arrays.asList("aaa","bbba","ccca","ddda");
        Assert.assertTrue(list.stream().anyMatch("aaa"::equals));
        //allMatch
        Assert.assertTrue(list.stream().allMatch(a->a.contains("a")));
    }
}
