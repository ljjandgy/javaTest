package InterfaceAndAbstractClass.AbstractClass.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @version sprint 19
 * @className AbsClass
 * @description
 * @date 2020-04-29 16:19:04
 */
public abstract class AbsClass {
    protected List<String> testList = new ArrayList<>();

    protected void addTest(String str){
        testList.add(str);
    }

    protected void sysout(){
        testList.forEach(System.out::println);
    }
}
