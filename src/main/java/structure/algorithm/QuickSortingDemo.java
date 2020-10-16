package structure.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 10
 * @className QuickSortingDemo
 * @description
 * @date 2020-10-15 19:11:36
 */
public class QuickSortingDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358,111,254,701,25,12,16,55};
        quickSorting(testArray,0,testArray.length-1);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void quickSorting(Integer[] testArray,int l,int r){
        int i=l;
        int j=r;
        if (i<j){
            int pivot = i;
            //先排序排序，找到中值
            while (i<j){
                while (testArray[j]>=testArray[pivot]&&i<j){
                    --j;
                }
                while (testArray[i]<=testArray[pivot]&&i<j){
                    ++i;
                }
                int temp = testArray[j];
                testArray[j] = testArray[i];
                testArray[i] = temp;
                System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
            }
            //把基数换到pivot位置上
            int temp = testArray[i];
            testArray[i] = testArray[pivot];
            testArray[pivot] = temp;
            //左递归
            quickSorting(testArray,l,i-1);
            //右递归
            quickSorting(testArray,i+1,r);
        }
    }
}
