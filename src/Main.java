import reflect.ReflectTest;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try{
            ReflectTest reflectTest = (ReflectTest)Class.forName("reflect.ReflectTest").newInstance();
            //reflectTest.test();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
