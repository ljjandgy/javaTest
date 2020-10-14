package structure.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 10
 * @className ShellSortingDemo
 * @description
 * @date 2020-10-13 19:16:27
 */
public class ShellSortingDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358,111,254,701,25,12,16};
        shellSorting(testArray);
        //shellSorting1(testArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    /**
     * 插入排序时采用交换法
     */
    private static void shellSorting(Integer[] testArray){
        int n = testArray.length/2;
        while (n>0){
            for (int i=n;i<testArray.length;++i){
                int j = i;
                while (j>=n&&testArray[j]<testArray[j-n]){
                    int temp = testArray[j];
                    testArray[j] = testArray[j-n];
                    testArray[j-n] = temp;
                    j = j-n;
                }

            }
            n = n/2;
        }
    }

    /**
     * 插入排序时采用移位法
     */
    private static void shellSorting1(Integer[] testArray){
        int n = testArray.length/2;
        while (n>0){
            for (int i=n;i<testArray.length;++i){
                if (testArray[i]<testArray[i-n]){
                    int j = i;
                    int temp = testArray[j];
                    while (j>=n&&temp<testArray[j-n]){
                        testArray[j] = testArray[j-n];
                        j = j-n;
                    }
                    testArray[j] = temp;
                }
            }
            n = n/2;
        }
    }

    private static void shellSorting2(Integer[] testArray){
        for (int n=testArray.length/2;n>0;n/=2){
            for (int i=n;i<testArray.length;i++){
                int j=i;
                int temp = testArray[j];
                if (testArray[j]<testArray[j-n]){
                    while (j>=n&&temp<testArray[j-n]){
                        testArray[j] = testArray[j-n];
                        j-=n;
                    }
                    testArray[j] = temp;
                }
            }
        }
    }
}
