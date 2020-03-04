package java8.lambda.base;

import java8.lambda.base.example.Comparator;
import java8.lambda.base.impl.ApplePredicateForColorAndHeavy;
import java8.lambda.base.impl.ApplePredicateForRed;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AppleFilter
 * @Description 筛选苹果
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
        //匿名类实现方式
        List<Apple> redAppleForAnonymousClass = appleFilter(originList, new ApplePredicate() {
            @Override
            public boolean appleTest(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        //lambda表达式格式
        List<Apple> redAppleForLambda = appleFilter(originList,(Apple aplle)->"red".equals(aplle.getColor()));
        //list类型抽象化
        List<Orange> orangeList = new ArrayList<>();
        orangeList.add(new Orange("红心大橘子","yellow",180));
        orangeList.add(new Orange("普通橘子","green",200));
        orangeList.add(new Orange("超大橘子","yello",800));
        //筛选大橘子
        List<Orange> bigOrage = filter(orangeList,(Orange orage)->orage.getWeight()>500);

        Comparator comparator = new Comparator();
        comparator.sortByAnonymousClass(originList);
        originList.forEach(apple -> System.out.println(apple.getName()));
        comparator.sortByLambda(originList);
        originList.forEach(apple -> System.out.println(apple.getName()));
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

    /**
     * 筛选各种类型的东西
     * @param objectList 被筛选的集合
     * @param predicate 筛选接口
     * @param <T> 筛选对象的类型
     * @return 筛选后的集合
     */
    private static <T>List<T> filter(List<T> objectList,Predicate<T> predicate){
        List<T> resultList = new ArrayList<>();
        for (T object:objectList){
            if (predicate.test(object)){
                resultList.add(object);
            }
        }
        return resultList;
    }
}
