package structure.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 10
 * @className InsertionSortingDemo
 * @description
 * @date 2020-10-12 19:44:50
 */
public class InsertionSortingDemo {
    public static void main(String[] args) {
        Integer[] testArray = {15,22,33,1,2,7,5,14,11,95,102,358,111,254,701,25,12,16};
        insertSorting(testArray);
        System.out.println(Stream.of(testArray).map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void insertSorting(Integer[] array){
        for(int i=1;i<array.length;++i){
            int insertValue = array[i];
            for (int j=i;j>=0;--j){
                if (j-1>=0&&insertValue<array[j-1]){
                    array[j] = array[j-1];
                }else{
                    if (j!=i){
                        array[j] = insertValue;
                    }
                    break;
                }
            }
        }
    }
}
