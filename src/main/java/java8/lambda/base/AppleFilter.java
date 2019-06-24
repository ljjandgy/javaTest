package java8.lambda.base;

import java8.lambda.base.impl.ApplePredicateForColorAndHeavy;
import java8.lambda.base.impl.ApplePredicateForRed;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AppleFilter
 * @Description
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-06-23 19:42:44
 */
public class AppleFilter {
    public static void main(String[] arg){
        List<Apple> originList = new ArrayList<>();
        originList.add(new Apple("烟台红富士","red",180));
        originList.add(new Apple("日本红富士","red",200));
        originList.add(new Apple("东北大苹果","green",500));
        //通过传递的参数（实现类决定具体的动作）
        List<Apple> redApple = appleFilter(originList,new ApplePredicateForRed());
        List<Apple> bigGreenApple = appleFilter(originList,new ApplePredicateForColorAndHeavy());
        redApple.forEach(apple -> {
            System.out.println("红苹果："+apple.getName());
        });
        bigGreenApple.forEach(apple -> {
            System.out.println("大绿苹果："+apple.getName());
        });

    }

    /**
     * 筛选苹果
     * @param originList 原始列表
     * @return 红苹果列表
     */
    private static List<Apple> appleFilter(List<Apple> originList,ApplePredicate applePredicate){
        List<Apple> redList = new ArrayList<>();
        for (Apple apple:originList){
            if (applePredicate.appleTest(apple)){
                redList.add(apple);
            }
        }
        return redList;
    }
}
