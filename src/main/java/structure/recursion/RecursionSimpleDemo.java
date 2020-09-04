package structure.recursion;

/**
 * @author ljj
 * @version sprint 27
 * @className RecursionSimpleDemo
 * @description
 * @date 2020-08-18 19:51:06
 */
public class RecursionSimpleDemo {
    public static void main(String[] args) {
        recursionTest(10);
    }

    private static void recursionTest(int n){
        if (n>1){
            recursionTest(n-1);
        }
        System.out.println(n);
    }
}
