package String;

import org.junit.Assert;

/**
 * @Author: LJJ
 * @Date: 2019/3/19 21:12
 * String常用方法记录
 */
public class StringTest {
    public static void main(String[] arg) {
        //返回的是第一个不相同字符的16进制换10进制之后的差值--后面减去前面
        System.out.println("aaa".compareTo("AAA"));
        System.out.println("aaa".startsWith("aa"));
        System.out.println("aaa".endsWith("bb"));
        //字符串拼接，第一个参数为界定符（需要重复的字符），用于平均后面所有的子串
        System.out.println(String.join("aaaa、、、", "aaaa", "//", "vvbas"));
    }
}
