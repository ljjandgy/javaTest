package structure;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 21
 * @className SparseArray
 * @description 稀疏数组
 * @date 2020-05-14 13:24:23
 */
public class SparseArray {
    /**
     * 普通二维数组转为稀疏数组
     * @return
     */
    private static int[][] commmonArrayToSparseArray(int[][] commonArray){
        Stream<int[]> arrayStram = Stream.of(commonArray);
        Long valueSum = arrayStram.flatMap(array-> Arrays.stream(array).boxed().filter(num->num!=0)).filter(num->num>0).count();
        //创建稀疏数组
        int[][] sparseArray = new int[valueSum.intValue()+1][3];
        sparseArray[0][0] = commonArray.length;
        sparseArray[0][1] = commonArray[0].length;
        sparseArray[0][2] = valueSum.intValue();
        //稀疏数组赋值
        int count = 0;
        for (int i = 0; i < commonArray.length; ++i) {
            for (int j = 0; j < commonArray[0].length; ++j) {
                if (commonArray[i][j]!=0){
                    ++count;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = commonArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    private static int[][] SparseArrayToCommonArray(int[][] sparseArray){
        //通过稀疏数组的第0行获取原始数组行列值
        int[][] commonArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            commonArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return commonArray;
    }

    public static void main(String[] args) {
        int[][] commonArray = new int[12][12];
        commonArray[3][6] = 15;
        commonArray[4][10] = 18;
        System.out.println("原始数组为：");
        for (int i = 0; i < commonArray.length; i++) {
            for (int i1 = 0; i1 < commonArray[0].length; i1++) {
                System.out.printf("%s\t",commonArray[i][i1]);
            }
            System.out.println();
        }

        int[][] sparsArray = commmonArrayToSparseArray(commonArray);
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparsArray.length; i++) {
            System.out.printf("%s\t%s\t%s\t\n",sparsArray[i][0],sparsArray[i][1],sparsArray[i][2]);
        }

        commonArray = SparseArrayToCommonArray(sparsArray);
        System.out.println("还原后的数组为：");
        for (int i = 0; i < commonArray.length; i++) {
            for (int i1 = 0; i1 < commonArray[0].length; i1++) {
                System.out.printf("%s\t",commonArray[i][i1]);
            }
            System.out.println();
        }

    }

}
