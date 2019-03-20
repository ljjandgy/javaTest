package classTest;

/**
 * @Author: LJJ
 * @Date: 2019/3/13 11:25
 */
public class ClassB extends ClassA {
    public ClassB(){
        System.out.println("3");
    }
    @Override
    public void run(){
        System.out.println("4");
    }
}
