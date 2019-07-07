package java8.lambda.practice.LambdaPractice;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 资源操作接口
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
