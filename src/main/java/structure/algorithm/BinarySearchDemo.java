package structure.algorithm;

/**
 * @author ljj
 * @version sprint 10
 * @className BinarySearchDemo
 * @description
 * @date 2020-11-11 15:59:56
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        Integer[] testArray = {1,2,5,7,11,14,15,22,33,95,102,358};
        int targetIndex = binarySearch(testArray,1000000,0,testArray.length-1);
        if (targetIndex==-1){
            System.out.println("目标在数组中不存在");
        }else{
            System.out.println("目标在数组中的索引为："+targetIndex);
        }

    }

    private static int binarySearch(Integer[] testArray,int target,int l,int r){
        if (l<=r){
            int mid = (l+r)/2;
            if (testArray[mid]==target){
                return mid;
            }else if (testArray[mid]>target){
                return binarySearch(testArray,target,l,mid-1);
            }else{
                return binarySearch(testArray,target,mid+1,r);
            }
        }
        return -1;
    }
}
