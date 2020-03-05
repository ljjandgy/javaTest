package format;

import org.junit.Test;

/**
 * @Author: LJJ
 * @Date: 2019/3/19 21:29
 */
public class OutFormat {
    @Test
    public void main(){
        System.out.printf("out print format %d",11);
    }
    @Test
    public void main1(){
        System.out.println(String.format("dddddddddddd%,2f",3333333.3333333));
    }
}
