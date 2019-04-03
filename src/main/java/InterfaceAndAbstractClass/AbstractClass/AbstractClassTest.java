package InterfaceAndAbstractClass.AbstractClass;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AbstractClassTest{
    public static void main(String[] arg){
        //new 出来的其实是子类的对象，而不是抽象方法的对象，变量是子类的引用
        AbstractList abstractList = new AbstractList() {
            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }
}
