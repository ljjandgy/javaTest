package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池oom测试
 */
public class RuntimeConstantOomTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        while (true) {
            int i = 0;
            //通过intern方法往常量池中添加String对象
            stringList.add(String.valueOf(i++).intern());
        }
}
}
