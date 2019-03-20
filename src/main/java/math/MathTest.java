package math;

/**
 * @Author: LJJ
 * @Date: 2019/3/18 13:06
 */
public class MathTest {
    public static void main(String[] arg){
        //平方根
        System.out.println(Math.sqrt(4));
        //幂运算
        System.out.println(Math.pow(4,2));
        //三角函数
        System.out.println(Math.sin(60));
        System.out.println(Math.cos(60));
        System.out.println(Math.tan(60));
        System.out.println(Math.atan(60));
        System.out.println(Math.atan2(60,60));
        //π和E
        System.out.println(Math.PI);
        System.out.println(Math.E);
        //指数运算
        //自然对数
        System.out.println(Math.exp(4));
        System.out.println(Math.log(4));
        System.out.println(Math.log10(4));
        //舍入运算
        System.out.println(Math.round(4.44));
        System.out.println(Math.round(4.5678));
    }
}
