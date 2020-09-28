package object;

import lombok.Data;
import lombok.NonNull;
import structure.linkedlist.Test;

/**
 * @author ljj
 * @version sprint 9
 * @className ObjectReferenceTest
 * @description
 * @date 2020-09-24 17:06:54
 */
public class ObjectReferenceTest {
    public static void main(String[] args) {
        Test1 test1 = new Test1("test1");
        Test1 test11 = new Test1("test11");
        test1.setTest1(test11);
        test1 = test11;
        System.out.println(test1.getName());
        System.out.println(test1.getTest1().getName());
    }
    @Data
    static class Test1{
        @NonNull
        private String name;
        private Test1 test1;
    }

}
