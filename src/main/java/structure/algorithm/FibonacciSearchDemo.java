package structure.algorithm;

import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * @author ljj
 * @version sprint 12
 * @className FibonacciSearchDemo
 * @description
 * @date 2020-11-17 20:17:31
 */
public class FibonacciSearchDemo {
    public static void main(String[] args) {
        Integer[] testArray = {1,2,5,7,11,14,15,22,33,95,102,358};
        int index = fibonacciSearch(testArray,1);
        if (index==-1){
            System.out.println("数组中不存在该数据");
        }else{
            System.out.println("目标数在数组中的位置为：" + index);
        }
    }

    private static int fibonacciSearch(Integer[] testArray,int target){
        if (testArray.length==0){
            return -1;
        }
        //当数组长度大于1时
        int fibonacciArrayLength = getFibonacciArrayLength(testArray.length);
        int[] tempArray = new int[fibonacciArrayLength];
        int index = 0;
        //初始化斐波那契查找所用的数组
        while (index<=fibonacciArrayLength-1){
            if (index>=testArray.length-1){
                tempArray[index] = testArray[testArray.length-1];
            }else{
                tempArray[index] = testArray[index];
            }
            ++index;
        }
        //开始斐波那契查找
        int targetIndex = fibonacciSearch(0,fibonacciArrayLength,tempArray,target);
        if (targetIndex>testArray.length-1){
            return testArray.length-1;
        }else{
            return targetIndex;
        }
    }

    private static int fibonacciSearch(int l,int arrayLength,int[] tempArray,int target){
        if (arrayLength>1){
            int mid = (l+getFibonacciMid(arrayLength))-1;
            if (tempArray[mid]==target){
                return mid;
            }else if(tempArray[mid]>target){
                return fibonacciSearch(0,mid+1,tempArray,target);
            }else{
                return fibonacciSearch(mid+1,tempArray.length-(mid+1),tempArray,target);
            }
        }
        if (tempArray[0]==target){
            return 0;
        }
        return -1;
    }

    /**
     * 根据原数组长度计算斐波那契数组长度
     * @param arrayLength 原数组最大
     * @return 斐波那契数组长度
     */
    private static int getFibonacciArrayLength(int arrayLength){
        int a;
        int b = 1;
        int c = 1;
        while(true){
            if (c>=arrayLength){
                return c;
            }else if((a=b+c)>=arrayLength){
                return a;
            }else if((b=a+c)>=arrayLength){
                return b;
            }else{
                c = a+b;
            }
        }
    }

    /**
     * 通过数组长度获取mid值
     * @param fibonacciArrayLength 斐波那契查找数组的长度
     * @return mid值
     */
    private static int getFibonacciMid(int fibonacciArrayLength){
        int a = 0;
        int b = 1;
        int c = 1;
        while(true){
            if (c==fibonacciArrayLength){
                return a>b?a:b;
            }else if((a=b+c)==fibonacciArrayLength){
                return b>c?b:c;
            }else if((b=a+c)==fibonacciArrayLength){
                return a>c?a:c;
            }else{
                c = a+b;
            }
        }
    }
}
