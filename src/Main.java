import reflect.ReflectTest;

import javax.sql.rowset.spi.SyncResolver;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
       /* try{
            ReflectTest reflectTest = (ReflectTest)Class.forName("reflect.ReflectTest").newInstance();
            //reflectTest.test();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            System.out.print("");
        }catch(Exception e){
            e.printStackTrace();
        }*/
        /*float x = 10700 - 9999.39f;
        float y = 10700 - 9993.67f;
        //保留三位小数
        return BigDecimal.valueOf(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))).setScale(3, BigDecimal.ROUND_HALF_DOWN);*/
        long test = -128;
        int pow = 0;
        while (test<0){
            test = test/2;
            ++pow;
        }
        System.out.println(pow);
        System.out.println(Math.pow(2,8));
        System.out.println(0b101);
        System.out.println(0xabc);
    }
}
