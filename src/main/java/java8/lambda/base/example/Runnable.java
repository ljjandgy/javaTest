package java8.lambda.base.example;

/**
 * 几种通过Runnable接口创建线程的方法
 */
public class Runnable {
    public static void main(String[] arg){
        //1.匿名类
        java.lang.Runnable runnable1 = new java.lang.Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程");
            }
        } ;
        //2.lambda表达式--可以用lambda表达式直接声明函数式接口
        java.lang.Runnable runnable2 = ()->System.out.println("我是lambda表达式线程");
        //1.利用定义好的runnable对象运行
        run(runnable1);
        run(runnable2);
        //2.直接利用lambda表达式作为参数代替函数式接口，而不是去定义函数式接口
        run(()->System.out.println("我是直接传递的lambda表达式"));
    }

    /**
     * 运行线程
     * @param runnable 线程对象
     */
    private static void run(java.lang.Runnable runnable){
        runnable.run();
    }
}
