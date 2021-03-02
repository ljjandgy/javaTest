package parentmethod;

import java.util.Map;

/**
 * @ClassName Parent
 * @Description
 * @Author YuGuo
 * @Date: 2021-03-02 11:14:57
 */
public class Parent {

    public void fun(Map<String, String> map) {
        System.out.println("parent");
        map.forEach((key, val)-> System.out.println("key:" + key + ", value:" + val));
    }
}
