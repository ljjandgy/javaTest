package parentmethod;

/**
 * @author ljj
 * @version sprint 38
 * @className A
 * @description 变量的类型是引用类型，然后方法只会使用引用类型里面定义的方法，在没有@Override的情况下，并不会考虑多态类的方法
 * @date 2021-03-02 14:24:08
 */
public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}
class B extends A {
    public String show(B obj) {
        return ("B and B");
    }
}

class C extends B {}

class D extends B {}

class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("(1)" + a1.show(b));
        System.out.println("(2)" + a1.show(c));
        System.out.println("(3)" + a1.show(d));
        System.out.println("(4)" + a2.show(b));
        System.out.println("(5)" + a2.show(c));
        System.out.println("(6)" + a2.show(d));
        System.out.println("(7)" + b.show(b));
        System.out.println("(8)" + b.show(c));
        System.out.println("(9)" + b.show(d));

    }
}
