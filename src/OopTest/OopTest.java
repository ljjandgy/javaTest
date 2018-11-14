package OopTest;

import static java.lang.System.*;

public class OopTest {

    public static void main(String[] args){
        for(int i = 10;i<100;i++){
            for (int j=i;j<100;j++){
                int a = i*j;

                String allStr = ""+i+j;
                if (allStr.equals(""+a)){
                    out.println(a+"|"+i+"|"+j);
                }
                /*String aa = String.valueOf(a);
                String i1 = aa.substring(0,1);
                String i2 = aa.substring(1,2);
                String j1 = aa.substring(2,3);
                String j2 = aa.substring(3,4);
                if(allStr.contains(i1)&&allStr.contains(i2)&&allStr.contains(j1)&&allStr.contains(j2)){
                    out.println(a+"|"+i+"|"+j);
                }*/
            }
        }
    }
}
