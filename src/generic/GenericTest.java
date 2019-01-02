package generic;

/**
 * 泛型示例类1
 */
public class GenericTest<T> {
    private T a;//泛型对象--示例时由外部对象来定具体的类型
    public GenericTest(T a){
        this.a = a;
    }

    /**
     * 初始化成员变量
     * @param a
     */
    public void set(T a){
        this.a = a;
    }

    /**
     * 获取泛型成员变量
     * @return a
     */
    public T get(){
        return a;
    }
}
