package structure.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 10
 * @className MergeSortingDemo
 * @description
 * @date 2020-10-19 14:35:56
 */
public class MergeSortingDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358};
        Integer[] tempArray = new Integer[testArray.length];
        MergeSorting(testArray,tempArray,0,tempArray.length-1);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void MergeSorting(Integer[] testArray,Integer[] tempArray,int l,int r){
        if (l<r){
            int mid = (l+r)/2;
            MergeSorting(testArray,tempArray,l,mid);
            MergeSorting(testArray,tempArray,mid+1,r);
            //对相邻序列进行排序操作
            int i = l;
            int j = mid+1;
            int index = l;
            while (i<=mid&&j<=r){
                if (testArray[i]<testArray[j]){
                    tempArray[index] = testArray[i];
                    ++i;
                }else{
                    tempArray[index] = testArray[j];
                    ++j;
                }
                ++index;
            }
            while (index<=r){
                if (i<=mid){
                    tempArray[index] = testArray[i];
                    ++i;
                    ++index;
                }else if(j<=r){
                    tempArray[index] = testArray[j];
                    ++j;
                    ++index;
                }
            }
            while (l<=r){
                testArray[r]=tempArray[r--];
            }
        }
    }
}