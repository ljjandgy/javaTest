package java8.lambda.practice.LambdaPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 由行为参数化操作去优化环绕执行模式
 */
public class ExecuteAroundByLambda {
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("E:\\demo.txt"))) {
            //相对于直接写死，这样就可以让该方法被复用
            return bufferedReaderProcessor.process(br);
        }
    }
}
