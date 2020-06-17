package structure.stack;

import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 21
 * @className ArrayStackDemo
 * @description 用数组模拟栈
 * @date 2020-06-16 19:35:56
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        Stream.iterate(0,i->i+1).limit(10).forEach(arrayStack::push);
        //遍历集合
        arrayStack.list();
        System.out.println("我出栈拉："+arrayStack.pop());
        arrayStack.list();
    }
}

class ArrayStack{
    //栈顶指针,顺序存储里面，序号就代表的是相应的对象。链式存储就不行
    private int top=-1;
    //栈本身
    private Object[] stack;
    //栈的最大容量
    private int maxStackSize;

    public ArrayStack(int maxStackSize){
        this.stack = new Object[maxStackSize];
        this.maxStackSize = maxStackSize;
    }

    /**
     * 入栈
     * @param obj 加入栈的对象
     */
    public void push(Object obj){
        if (isFull()){
            throw new IllegalArgumentException("栈已满，不能入栈");
        }
        //先移动栈顶指针
        top++;
        //然后保存对象
        stack[top] = obj;
    }

    /**
     * 出栈
     * @return 栈顶对象
     */
    public Object pop(){
        if (isNull()){
            throw new NullPointerException("栈为空，不能出栈");
        }
        Object temp = stack[top];
        stack[top] = null;
        top--;
        return temp;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if (isNull()){
            System.out.println("栈为空~~");
            return;
        }
        for (int i =0;i<=top; ++i){
            System.out.println(stack[i].toString());
        }
    }
    /**
     * 判断栈是否为空
     * @return true：空
     */
    private boolean isNull(){
        return top == -1;
    }

    /**
     * 判断栈是否已满
     * @return true：已满
     */
    private boolean isFull(){
        return top == maxStackSize - 1;
    }

}
