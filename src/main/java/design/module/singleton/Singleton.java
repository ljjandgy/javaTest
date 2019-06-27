package design.module.singleton;

/**
 * @ClassName Singleton
 * @Description 一个简单的单例类
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-06-24 13:06:44
 */
public class Singleton {
    /**
     * 自己生成实例
     */
    private static final Singleton SINGLETON = new Singleton();
    /**
     * 外部对象获取实例
     */
    public static Singleton getInstance(){
        return SINGLETON;
    }
    /**
     * 私有化单构造方法
     */
    private Singleton(){};
}
