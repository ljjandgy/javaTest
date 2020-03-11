package jvm.oom;

/**
 * 栈异常测试，包含StackOverflowTest和OutOfMemoryTest,本类展示oom异常
 * oom通常发生在多线程场景中（线程创建过多）
 */
public class StackOomTest {
    static class StackOomOp{
        /**
         * 死循环，让线程一致不能被销毁
         */
        private void holdOnThread(){
            while (true){

            }
        }
        public void createNewThread(){
            while (true){
                Thread thread = new Thread(this::holdOnThread);
                thread.start();
            }
        }

    }
    public static void main(String[] args) {
        StackOomOp stackOomOp = new StackOomOp();
        stackOomOp.createNewThread();
    }
}
