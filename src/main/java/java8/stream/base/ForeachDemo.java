package java8.stream.base;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 26
 * @className ForeachDemo
 * @description 针对foreach打断的事件
 * @date 2020-08-12 16:51:27
 */
public class ForeachDemo {
    public static void main(String[] args) {
        //普通foreach循环
        Stream.iterate(0,n->n+1).limit(20).forEach(System.out::println);
        //利用return跳出当前循环
        Stream.iterate(0,n->n+1).limit(20).forEach(n->{
            if (n==5){
                return;
            }
            System.out.println(n);
        });
        //当只是想用循环判断某个条件是否成立时，可以使用anymMtch()代替for循环
        //比如判断一个方法在规定次数中能否执行成功
        boolean flag = Stream.iterate(0,n->n+1).limit(20).anyMatch(n->
            someMethod()
        );
        if (!flag){
            throw new RuntimeException("业务执行失败");
        }
        Arrays.asList("111","222","333").forEach(num->{
            if ("222".equals(num)){
                return;
            }
            System.out.println(num);
        });
    }

    private static boolean someMethod(){
        //某个业务执行成功时
        if (true){
            return true;
        }else{
            return false;
        }
    }
}
