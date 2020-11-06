package structure.algorithm;

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
        radixSort(testArray,10);
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
            System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
            radixSort(testArray,num*10);
        }
    }

}
