package java8.lambda.practice.LambdaPractice.newfunctioninterface;

import java8.lambda.base.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 函数接口function的实际应用，function接口常用于实现对象属性的提取及使用--常见使用的例子是stream的map方法
 */
public class Function {
    public static void main(String[] arg){
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("大大苹果","red",800));
        appleList.add(new Apple("红富士","red",500));
        List<String> list = map(appleList,Apple::getColor);
        //不是有多个属性的对象可以直接输出
        list.forEach(System.out::println);
    }

    /**
     * map方法实现
     * @param list 入参集合，为被操作对象
     * @param function function接口
     * @param <T> 被操作对象类型
     * @param <R> 返回值类型--命名不同，表示泛型的类型是不一样的，可以简单理解为名称和类型是对应的
     * @return 操作完后的集合
     */
    private static <T,R> List<R> map(List<T> list, java.util.function.Function<T,R> function){
        List<R> result = new ArrayList<>();
        for (T t : list){
            //利用外部传入的行为对对象进行操作
            result.add(function.apply(t));
        }
        return result;
    }

}
