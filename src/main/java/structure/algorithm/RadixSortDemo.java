package structure.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 10
 * @className RadixSortDemo
 * @description
 * @date 2020-11-05 19:45:28
 */
public class RadixSortDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358};
        //radixSort(testArray,10);
        redixSortOptimize(testArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void radixSort(Integer[] testArray,int num){
        //用来排序的桶数组
        Integer[][] bucketArray = new Integer[10][testArray.length];
        boolean hasNext = false;
        for (Integer value:testArray){
            if (value>=num&&!hasNext){
                hasNext = true;
            }
            int temp = value%num;
            if (num>10){
                temp = (temp-temp%(num/10))/(num/10);
            }
            for(int i=0;i<10;i++){
                if (bucketArray[temp][i]==null){
                    bucketArray[temp][i] = value;
                    break;
                }
            }
        }
        int index = 0;
        for (Integer[] array:bucketArray){
            for (Integer value:array){
                if (value!=null){
                    testArray[index] = value;
                    ++index;
                }
            }
        }
        if (hasNext){
            radixSort(testArray,num*10);
        }
    }

    private static void redixSortOptimize(Integer[] testArray){
        int max = testArray[0];
        for (int i = 1; i < testArray.length; i++) {
            if (testArray[i]>max) {
                max = testArray[i];
            }
        }
        // 个位数: array[i] / 1 % 10 = 3
        // 十位数：array[i] / 10 % 10 = 9
        // 百位数：array[i] / 100 % 10 = 5
        // 千位数：array[i] / 1000 % 10 = ...
        for (int divider = 1; divider <= max; divider*=10) {
            // 开辟内存空间，存储次数
            int[] counts = new int[10];
            // 统计每个整数出现的次数
            for (Integer integer : testArray) {
                counts[integer / divider % 10]++;
            }

            // 累加次数，统计每个桶最大的索引值，用于后续确认元素位置
            //累加完后，假如counts[2]=6，说明第三个桶里面的数最大索引为5
            for (int i = 1; i < counts.length; i++) {
                counts[i]+= counts[i-1];
            }

            //从后向前遍历元素，将她放在有序数组中的合适位置
            int[] newArray = new int[testArray.length];
            for (int i = testArray.length-1; i >=0 ; i--) {
                //获取元素在counts中的索引
                int index = testArray[i]/divider%10;
                //放在合适位置
                newArray[--counts[index]] = testArray[i];
            }
            // 将有序数组赋值到array
            for (int i = 0; i < newArray.length; ++i) {
                testArray[i] = newArray[i];
            }
        }
    }
}
