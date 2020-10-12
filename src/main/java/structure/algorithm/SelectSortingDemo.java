package structure.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 9
 * @className SelectSortingDemo
 * @description 算法思路其实和冒泡排序类似，也是双重遍历，然后每次遍历都取区间内的最小值和i-1上的数交换，直到i=数组长度
 * @date 2020-09-29 16:49:36
 */
public class SelectSortingDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358,111,254,701,25,12,16};
        selectSorting(testArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void selectSorting(Integer[] array){
        for (int i=0;i<array.length;++i){
            int min = array[i];
            int index = i;
            for (int j=i+1;j<array.length;++j){
                if (array[j]<min){
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }

}
