import reflect.ReflectTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        try{
            ReflectTest reflectTest = (ReflectTest)Class.forName("reflect.ReflectTest").newInstance();
            //reflectTest.test();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            System.out.print("");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
