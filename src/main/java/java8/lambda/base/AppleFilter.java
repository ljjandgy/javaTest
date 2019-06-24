package java8.lambda.base;

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

    }

    /**
     * 获取红苹果
     * @param originList 原始列表
     * @return 红苹果列表
     */
    public List<Apple> getRedApple(List<Apple> originList,ApplePredicate applePredicate){
        List<Apple> redList = new ArrayList<>();
        for (Apple apple:originList){
            if (applePredicate.appleTest(apple)){
                redList.add(apple);
            }
        }
        return redList;
    }
    public List<Apple> getHeavyAndGreedApple(List<Apple> originList,ApplePredicate applePredicate){
        List<Apple> HeavyAndGreedList = new ArrayList<>();
        for (Apple apple:originList){
            if (applePredicate.appleTest(apple)){
                HeavyAndGreedList.add(apple);
            }
        }
        return HeavyAndGreedList;
    }
}
