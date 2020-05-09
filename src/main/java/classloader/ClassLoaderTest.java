package classloader;

/**
 * @author ljj
 * @version sprint 19
 * @className ClassLoaderTest
 * @description
 * @date 2020-05-08 20:03:27
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader" + classLoader);
        System.out.println("current loader parent"+classLoader.getParent());
        System.out.println("current loader grandFather"+classLoader.getParent().getParent());
    }
}
