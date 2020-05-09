package InterfaceAndAbstractClass.AbstractClass.common;

/**
 * @author ljj
 * @version sprint 19
 * @className MainTest
 * @description 每个子类创建时都会重新创建一个父类来匹配子类
 * @date 2020-04-29 19:22:24
 */
public class MainTest {
    static final Object lock = new Object();
    public synchronized static void main(String[] args) {
        synchronized (lock){
            ChildClass1 childClass1 = new ChildClass1();
            childClass1.addTest();
            childClass1.addTest();
            childClass1.syso();
            ChildClass2 childClass2 = new ChildClass2();
            childClass2.addTest();
            childClass2.syso();
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
