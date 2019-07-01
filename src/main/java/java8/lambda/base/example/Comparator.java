package java8.lambda.base.example;

import java8.lambda.base.Apple;

import java.util.List;

/**
 * 行为参数化--排序实践
 * 在jdk中一个很常见的行为参数化的实践就是集合排序，因为下面代码充当的是程序使用者的身份，所以就不使用泛型了，而且直接指定类型为苹果
 * Comparator接口的compare方法返回值大于0会把o1对象和o2对象位置交换（前后对象互换位置），其他都保持不动
 */
public class Comparator {
    /**
     * 通过匿名类实现集合排序
     * @param list 待排序集合
     * @return 排序完成的集合
     */
    public void sortByAnonymousClass(List<Apple> list){
        list.sort(new java.util.Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o2.getWeight()-o1.getWeight();
            }
        });
    }

    /**
     * 通过lambda表达式实现集合排序
     * @param list 待排序集合
     * @return 排序后的集合
     */
    public void sortByLambda(List<Apple> list){
        list.sort(java.util.Comparator.comparingInt(Apple::getWeight));
    }

}
