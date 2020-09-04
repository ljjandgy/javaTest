package structure.recursion;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 27
 * @className MazeProblemDemo
 * @description
 * @date 2020-08-20 19:12:28
 */
public class MazeProblemDemo {
    /**
     * 初始化地图,1表示障碍物
     */
    private int[][] initMaze(){
        int[][] maze = new int[7][8];
        //初始化边缘障碍物
        for (int i=0;i<8;i++){
            maze[0][i] = 1;
            maze[6][i] = 1;
        }
        for (int i=0;i<7;i++){
            maze[i][0] = 1;
            maze[i][7] = 1;
        }
        //增加自定义障碍物
        maze[3][0] = 1;
        maze[3][1] = 1;
        maze[3][2] = 1;

        return maze;
    }

    /**
     * 行走，我们定义走过的地方值为2，没办法走通的地方值为3,
     * 本次行走按照右下左上的顺序进行
     */
    private boolean step(int x,int y,int[][] maze){
        //走到了迷宫的出口
        if (maze[5][6]==2){
            return true;
        }else if (maze[x][y]==0){
            maze[x][y]=2;
            if (step(x+1,y,maze)){
                return true;
            }else if(step(x,y+1,maze)){
                return true;
            }else if(step(x-1,y,maze)){
                return true;
            }else if(step(x,y-1,maze)){
                return true;
            } else {
                //上下左右都走不通时
                maze[x][y]=3;
                return false;
            }
        }else{
            //说明这个点不能走了
            return false;
        }
    }

    public static void main(String[] args) {
        MazeProblemDemo mazeProblemDemo = new MazeProblemDemo();
        int[][] maze = mazeProblemDemo.initMaze();
        mazeProblemDemo.step(1,1,maze);
        for (int i=0;i<maze.length;i++){
            Arrays.stream((maze[i])).forEach(System.out::print);
            System.out.println();
        }
    }
}
