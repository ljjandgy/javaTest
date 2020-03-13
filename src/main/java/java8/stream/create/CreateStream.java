package java8.stream.create;

import org.junit.Test;
import org.omg.CORBA.portable.ValueOutputStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version V2.0
 * @className CreateStream
 * @description
 * @date 2020-03-12 13:06:57
 */
public class CreateStream {
    @Test
    public void valueTest(){
        Stream<String> stringStream = Stream.of("aaa","bbb","cccc");
        stringStream.forEach(System.out::println);
    }
    @Test
    public void arrayTest(){
        String aaa = "aa,b,c,d,e,d,e,e,t,r,e,w";
        Stream<String> stringStream = Arrays.stream(aaa.split(","));
        stringStream.forEach(System.out::println);
    }
    @Test
    public void fileTest(){
        long word = 0;
        //通过Files.lines把文件的每一行都转换成流
        try(Stream<String> stringStream = Files.lines(Paths.get("D:\\dictionary.txt"), Charset.defaultCharset())){
            word = stringStream.flatMap(line->Arrays.stream(line.split(" "))).distinct().count();
            System.out.println(word);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void functionTest(){
        //通过iterate函数生成无限流,seed是初始值，lambda表达式入参是上一个元素，返回值是当前元素
        Stream.iterate(0,n->n+2).limit(20).forEach(System.out::println);
        //通过generate函数生成无限流
        Stream.generate(Math::random).limit(20).forEach(System.out::println);
    }
}
