package structure.algorithm;

/**
 * @author ljj
 * @version sprint 12
 * @className InterpolationSearchDemo
 * @description
 * @date 2020-11-11 20:23:07
 */
public class InterpolationSearchDemo {
    public static void main(String[] args) {
        Integer[] testArray = {1,2,5,7,11,14,15,22,33,95,102,358};
        int targetIndex = interpolationSearch(testArray,102,0,testArray.length-1);
        if (targetIndex==-1){
            System.out.println("目标在数组中不存在");
        }else{
            System.out.println("目标在数组中的索引为："+targetIndex);
        }
    }

    private static int interpolationSearch(Integer[] testArray,int target,int l,int r){
        //计算“中值”的方式和二分查找不一样,插值查找是根据目标值所占的比例计算开始查找的位置
        if (l<=r){
            int mid = l+(r-l)*(target-testArray[l])/(testArray[r]-testArray[l]);
            if (target==testArray[mid]){
                return mid;
            }else if(target>testArray[mid]){
                return interpolationSearch(testArray,target,mid+1,r);
            }else{
                return interpolationSearch(testArray,target,l,mid-1);
            }
        }
        return -1;
    }
}
