package java8.lambda.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 环绕模式例子
 */
public class ExecuteAroundExample {
    public static String processFile() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("demo.txt"))) {
            return br.readLine();
        }
    }
}
