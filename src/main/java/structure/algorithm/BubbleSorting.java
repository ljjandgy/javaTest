package structure.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 9
 * @className BubbleSorting
 * @description
 * @date 2020-09-28 08:44:17
 */
public class BubbleSorting {

    public static void main(String[] args) {
        Integer[] testArray = {-1,20,50,88,5,4,6,2};
        //基本冒泡排序
        commonBubbleSorting(testArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
        //优化冒泡排序
        optimizedBubbleSorting(testArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void commonBubbleSorting(Integer[] testArray){
        int temp = 0;
        for (int i=0;i<testArray.length-1;++i){
            for (int j=0;j<testArray.length-1-i;++j){
                if (testArray[j]>testArray[j+1]){
                    temp = testArray[j+1];
                    testArray[j+1] = testArray[j];
                    testArray[j] = temp;
                }
            }
        }
    }

    private static void optimizedBubbleSorting(Integer[] testArray){
        boolean flag = false;
        int temp = 0;
        for (int i=0;i<testArray.length-1;++i){
            //如果循环了一次，都没有发生交换，说明已经有序了，就不用继续排序了
            if (flag){
                break;
            }
            flag = false;
            for (int j=0;j<testArray.length-i-1;++j){
                if (testArray[j]>testArray[j+1]){
                    temp = testArray[j+1];
                    testArray[j+1] = testArray[j];
                    testArray[j] = temp;
                    flag = true;
                }
            }
        }
    }
}
