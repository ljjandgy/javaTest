package object;

/**
 * @Author: LJJ
 * @Date: 2019/3/20 22:07
 * 域初始化测试
 */
public class FieldInit {
    private String a;
    private int b;
    private double c;
    private long d;

    {
        System.out.println("代码块3初始化");
        System.out.println("filed value:"+a+"\n"+b+"\n"+c+"\n"+d);
        b = 1;
    }

    {
        System.out.println("代码块1初始化");
        System.out.println("filed value:"+a+"\n"+b+"\n"+c+"\n"+d);
        b = 1;
    }
    {
        System.out.println("代码块2初始化");
        System.out.println("filed value:"+a+"\n"+b+"\n"+c+"\n"+d);
        b = 1;
    }
    {
        System.out.println("代码块4初始化");
        System.out.println("filed value:"+a+"\n"+b+"\n"+c+"\n"+d);
        b = 1;
    }

    static {
        System.out.println("静态代码块初始化");
    }
    public FieldInit(){
        System.out.println("构造方法初始化");
        System.out.println("filed value:"+a+"\n"+b+"\n"+c+"\n"+d);
        a = "";
    }
}
