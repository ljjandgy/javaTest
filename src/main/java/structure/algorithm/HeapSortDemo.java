package structure.algorithm;

import java.time.temporal.Temporal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 34
 * @className HeapSortDemo
 * @description
 * @date 2020-12-22 19:56:04
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358};
        //构建大顶堆
        /*for (int i=testArray.length-1;i>=0;--i){
            sift(testArray,i);
        }
        //把根节点放到最后，剩下的继续构建大顶堆
        for (int i=testArray.length-1;i>0;i--){
            //交换根节点和未排序的最后一个节点
            int temp = testArray[0];
            testArray[0] = testArray[i];
            testArray[i] = temp;
            for (int j=i-1;j>=0;j--){
                sift(testArray,j);
            }
        }*/
        for (int i=testArray.length/2-1;i>=0;--i){
            sift(testArray,i,testArray.length);
        }
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
        for (int i=testArray.length-1;i>0;--i){
            int temp = testArray[0];
            testArray[0] = testArray[i];
            testArray[i] = temp;
            sift(testArray,0,i);
        }
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    public static void heapSort(Integer[] array){
        for (int i=array.length/2-1;i>=0;--i){
            sift(array,i,array.length);
        }
        for (int i=array.length-1;i>0;--i){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            sift(array,0,i);
        }
    }

    /*private static void sift(Integer[] testArray,int now){
        int parent =(now-1)/2;
        //当根节点小于子节点，就交互（因为要构造的是大顶堆）
        if (parent>=0&&testArray[parent]<testArray[now]){
            int temp = testArray[parent];
            testArray[parent] = testArray[now];
            testArray[now] = temp;
        }
    }*/

    /**
     * 把以now节点为根节点的树构建为大顶堆
     * @param testArray 待排序数组
     * @param now 当前节点
     * @param length 能够操作数组的最大长度（已经完成排序的数组就不用在参与堆的构建了）
     */
    private static void sift(Integer[] testArray,int now,int length){
        int temp = testArray[now];
        int i = 2*now+1;
        while(i<length){
            if (i+1<length&&testArray[i]<testArray[i+1]){
                ++i;
            }
            if (temp<testArray[i]){
                testArray[now] = testArray[i];
                now = i;
            }else{
                //如果子节点都比当前节点小，说明就不用再往下比较了
                break;
            }
        }
        testArray[now] = temp;
    }
}
