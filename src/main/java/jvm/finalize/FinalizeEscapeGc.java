package jvm.finalize;

/**
 * 通过finalize方法逃脱gc测试
 * 不过通过finalize逃脱gc的机会只有一次，也就是说一个类只会被JVM调用一次finalize方法
 */
public class FinalizeEscapeGc {
    //类静态变量，可以作为根节点
    public static FinalizeEscapeGc SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("is alive");
    }
    @Override
    public void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize is execute");
        FinalizeEscapeGc.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception{
        SAVE_HOOK = new FinalizeEscapeGc();

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(5000);
        //等待500毫秒等待finalize方法的自动调用
        if (SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("i am dead");
        }


    }
}
