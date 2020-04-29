package InterfaceAndAbstractClass.AbstractClass.test1;

/**
 * @author ljj
 * @version sprint 19
 * @className MainTest
 * @description
 * @date 2020-04-29 16:25:11
 */
public class MainTest {
    public static void main(String[] args) {
        AbsClass absClass1 = new AbsClass() {
            @Override
            protected void addTest(String str) {
                super.addTest(str+"1");
            }
        };

        AbsClass absClass2 = new AbsClass() {
            @Override
            protected void addTest(String str) {
                super.addTest(str+"2");
            }
        };

        absClass1.addTest("aaa");
        absClass2.addTest("bbb");
        absClass1.testList.forEach(System.out::println);
        absClass1.sysout();

        SubClass1 subClass1 = new SubClass1();
        subClass1.addTest("subclass1");
        SubClass2 subClass2 = new SubClass2();
        subClass2.addTest("subclass2");
        subClass1.sysout();

    }
}
