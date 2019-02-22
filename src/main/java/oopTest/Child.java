package oopTest;

import java.util.Collections;
import java.util.HashMap;

/**
 * 子类
 */
public class Child extends Father{
    private static int mem;
    public Child() {
        System.out.println("子类版本构造函数");
        System.out.println("子类的mem初始值"+mem);
        this.mem=2;
        HashM暗红色ap
    }
    public void Out() {
        System.out.println("这里是子类的输出方法"+this.mem);
    }
    public static void OutLn() {
        System.out.println("这是子类的静态方法");
    }
}
