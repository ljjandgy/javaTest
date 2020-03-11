package jvm.oom;

/**
 * 栈长度长度超长异常测试,单线程下出现的已办都是overflow错误
 */
public class StackOverflowTest {
    static class OverflowTest{
        int stackLength = 1;
        public void addStackLength(){
            stackLength++;
            addStackLength();
        }
    }
    public static void main(String[] args) {
        OverflowTest overflowTest = new OverflowTest();
        try{
            overflowTest.addStackLength();
        }catch (Throwable e){
            System.out.println("stack length:"+overflowTest.stackLength);
            throw e;
        }
    }
}
