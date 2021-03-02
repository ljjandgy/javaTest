package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJJ
 * @Date: 2019/3/20 13:00
 */
public class ArrayTest {
    @Test
    public void test1() {
        int[] array = new int[] {1, 2, 3, 4};
    }
    @Test
    public void test() {
        List<String> list = Arrays.asList("1", "2", "3");
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
    }
}
