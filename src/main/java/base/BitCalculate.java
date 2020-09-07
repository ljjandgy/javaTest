package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 8
 * @className BitCalculate
 * @description
 * @date 2020-09-07 11:56:29
 */
public class BitCalculate {
    public static void main(String[] args) {
        //无符号左移
        System.out.println(3 << 2);
        //有符号左移
        System.out.println(-3 << 2);
        //有符号右移
        //负数至少都是1，不可能为0，因为要保留符号
        System.out.println(-3 >> 2);
        System.out.println(3 >> 2);
        //无符号右移
        System.out.println(-3 >>> 2);
        //位与运算
        System.out.println(5 & 3);
        //位或运算
        System.out.println(5 | 3);
        //位异或运算(不同取或，相同取与)
        System.out.println(5 ^ 3);
        //位非运算
        System.out.println(~5);
        System.out.println(Integer.MAX_VALUE);
    }
}
