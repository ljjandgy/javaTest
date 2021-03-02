package parentmethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Child
 * @Description
 * @Author YuGuo
 * @Date: 2021-03-02 11:16:51
 */
public class Child extends Parent {
    public void fun(HashMap<String, String> map) {
        System.out.println("child");
        map.forEach((key, val)-> System.out.println("key:" + key + ", value:" + val));
    }
}
