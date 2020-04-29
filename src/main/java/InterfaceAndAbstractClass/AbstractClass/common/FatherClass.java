package InterfaceAndAbstractClass.AbstractClass.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @version sprint 19
 * @className FatherClass
 * @description
 * @date 2020-04-29 19:18:11
 */
public class FatherClass {
    protected List<String> testList = new ArrayList<>();

    public void addTest(){
        testList.add("test");
    }

    public void syso(){
        System.out.println("集合长度为："+testList.size());
        testList.forEach(System.out::println);
    }
}
