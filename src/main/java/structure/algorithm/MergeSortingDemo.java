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
        //MergeSortingTopToDown(testArray,tempArray,0,tempArray.length-1);
        MergeSortingBottomToTop(testArray,tempArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void MergeSortingTopToDown(Integer[] testArray,Integer[] tempArray,int l,int r){
        if (l<r){
            int mid = (l+r)/2;
            MergeSortingTopToDown(testArray,tempArray,l,mid);
            MergeSortingTopToDown(testArray,tempArray,mid+1,r);
            //对相邻序列进行排序操作
            int i = l;
            int j = mid+1;
            int index = l;
            while (i<=mid&&j<=r){
                if (testArray[i]<=testArray[j]){
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

    private static void MergeSortingBottomToTop(Integer[] testArray,Integer[] tempArray){
        int k = 1;
        while (k<=testArray.length/2){
            int l = 0;
            int r = 2*k-1;
            while (r<testArray.length){
                int mid = (l+r)/2;
                int i = l;
                int j = mid + 1;
                int index = l;
                merge(i,j,mid,r,index,testArray,tempArray);
                l = r+1;
                r = l+2*k-1;
            }
            int temp = tempArray.length-1;
            while (temp>=0){
                testArray[temp]=tempArray[temp--];
            }
            k = k*2;
        }
        if (k>testArray.length/2){
            int r = testArray.length-1;
            int i = 0;
            int mid = k-1;
            int index = 0;
            merge(i,k,mid,r,index,testArray,tempArray);
            while (r>=0){
                testArray[r]=tempArray[r--];
            }
        }
    }

    private static void merge(int i,int j,int mid,int r,int index,Integer[] testArray,Integer[] tempArray){
        while (i<=mid&&j<=r){
            if (testArray[i]<=testArray[j]){
                tempArray[index] = testArray[i];
                ++i;
                ++index;
            }else{
                tempArray[index] = testArray[j];
                ++j;
                ++index;
            }
        }
        while (index<=r){
            if (i<=mid){
                tempArray[index] = testArray[i];
                ++i;
            }else if(j<=r){
                tempArray[index] = testArray[j];
                ++j;
            }
            ++index;
        }
    }
}