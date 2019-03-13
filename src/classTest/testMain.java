package classTest;

/**
 * @Author: LJJ
 * @Date: 2019/3/13 11:25
 */
public class testMain {
    public static void main(String[] args){
        ClassB b = new ClassB();
        b.run();
        ClassA a = b;
        a.run();
        System.out.println(a.getClass()==ClassA.class);
        System.out.println(b.getClass()==ClassB.class);
        System.out.println(a.getClass()==ClassB.class);
    }
}
