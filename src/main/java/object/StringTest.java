package object;

/**
 * @author ljj
 * @version sprint 9
 * @className StringTest
 * @description
 * @date 2020-09-17 16:38:55
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        String s4 = "a"+"a"+"a";
        String s5 = "aa";
        //toString会new一个String对象，所以地址不一样了
        String s6 = s5+"a";
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s4 == s1);
        System.out.println(s6 == s1);
    }
}
