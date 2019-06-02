package reflect.reflecttest;

/**
 * @ClassName ClassTest
 * @Description
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-04-03 13:05:38
 */
public class ClassTest {
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.setName("老王");
        Class cl = employee.getClass();
        System.out.println(cl.getName());
    }
}
