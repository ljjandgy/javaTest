package oopTest;

/**
 * 父类
 */
public class Father{
    private static int mem=1;
    public Father() {
                System.out.println("基类版本构造函数");
             }
    public void Out() {
                 System.out.println("这里是父类的输出方法"+mem);
             }
     public static void  OutLn() {
                 System.out.println("这是父类的静态函数");
             }
}
