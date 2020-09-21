package structure.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 8皇后问题
 */
public class EightQueenDemo {
    int count = 0;
    public Integer[] queenArray = new Integer[8];
    /**
     * 具体解题思路如下：
     * 1.先放置一个皇后在棋盘的第一行第一列
     * 2.放置第二个皇后在第二行第一列，如果会被第一行的皇后攻击，就后移一列，知道不被攻击为止
     * 3.重复2的操作去放置每一行的皇后，如果某一行的皇后放置到每一列都会被攻击，那么就回溯到上一个皇后，移动上一个皇后的位置后，再放置当前行
     * 4.如果8个皇后都放置完了，那么就说明得到一种解法
     * @param args
     */
    public static void main(String[] args) {
        EightQueenDemo eightQueenDemo = new EightQueenDemo();
        eightQueenDemo.put(0);
        System.out.println("一共有"+eightQueenDemo.count+"种解法");
    }

    /**
     * 因为使用了递归，所以put方法会把棋盘所有位置都尝试一遍才会执行完毕
     */
    public void put(int n){
        if (n==8) {
            System.out.println(getLocation());
            for (int i=0;i<8;i++){
                for (int j=0;j<8;++j){
                    if (queenArray[i]==j){
                        System.out.print(" 1 ");
                    }else{
                        System.out.print(" 0 ");
                    }
                }
                System.out.println();
            }
            count++;
        }else {
            for (int i=0;i<8;++i){
                queenArray[n]=i;
                if (!check(n)){
                    //当本行皇后放置的位置符合要求，那么就去放置下一行的皇后的位置
                    put(n+1);
                }
            }
        }
    }

    /**
     * 判断放的皇后是否会被攻击
     * 1.queenArray[i]==queenArray[n]表示当前皇后放置的位置和之前某个皇后在同一列
     * 2.Math.abs(i-n)== Math.abs(queenArray[i]-queenArray[n])表示皇后和之前一个皇后在同一斜线上
     * @param n 当前放置皇后的行数
     * @return 是否会被攻击 true：会被攻击到
     */
    private boolean check(int n){
        for (int i=0;i<n;++i){
            if (queenArray[i].intValue() == queenArray[n].intValue()||Math.abs(i-n)== Math.abs(queenArray[i]-queenArray[n])){
                return true;
            }
        }
        return false;
    }

    private String getLocation(){
        return "{"+ new ArrayList<>(Arrays.asList(queenArray)).stream().map(String::valueOf).collect(Collectors.joining(","))+"}";
    }
}
