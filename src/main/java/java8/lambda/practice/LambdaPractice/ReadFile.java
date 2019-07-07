package java8.lambda.practice.LambdaPractice;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 文件读取类
 */
public class ReadFile {
    public static void main(String[] arg){
        try {
            System.out.println(readOneLine());
            System.out.println(readTwoLine());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 读取一行
     * @return 读取的内容
     */
    public static String readOneLine() throws IOException {
        return ExecuteAroundByLambda.processFile(BufferedReader::readLine);
    }

    /**
     * 读取两行
     * @return 读取的内容
     */
    public static String readTwoLine() throws IOException{
        return ExecuteAroundByLambda.processFile((BufferedReader bufferedReader)->bufferedReader.readLine()+bufferedReader.readLine());
    }

}
