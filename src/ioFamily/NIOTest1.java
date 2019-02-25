package ioFamily;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @Author: LJJ
 * @Date: 2019/2/24 21:19
 */
public class NIOTest1 {
    public static void main(String[] arg){
        ByteBuffer byteBuffer = Charset.defaultCharset().encode("hello world！");
        System.out.println(byteBuffer);
    }
}
