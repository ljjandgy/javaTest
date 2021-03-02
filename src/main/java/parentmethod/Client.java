package parentmethod;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName Client
 * @Description
 * @Author YuGuo
 * @Date: 2021-03-02 11:20:07
 */
public class Client {
    public static void main(String[] args) {
        Child parent = new Child();
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("1", "str1");
        hashMap.put("2", "str3");
        parent.fun(hashMap);
    }
}
