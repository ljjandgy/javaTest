package enumtest;
import static java.lang.System.*;

public class EnumTest {
    public static void main(String[] arg){
        out.println(Enum1.TEST==Enum1.TEST1);
        out.println(Enum1.TEST.toString());
        out.println(Enum1.TEST.name());
        out.println(Enum1.TEST.getTest1());
        out.println(Enum1.TEST.getTest2());
    }
}
