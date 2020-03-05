package apache.common.lang;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @version V2.0
 * @className String
 * @description
 * @date 2020-03-05 15:41:04
 */
public class String {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        if (ObjectUtils.isEmpty(list)){
            System.out.println("集合为空");
        }

    }
}
