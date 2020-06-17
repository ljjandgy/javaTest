package structure.stack;

import lombok.Data;

import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 21
 * @className LinkedStackDemo
 * @description 使用单链表实现栈
 * @date 2020-06-16 20:02:22
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LikedStack linkedStack = new LikedStack(10);
        //初始化栈
        Stream.iterate(0,i->i+1).limit(10).forEach(i->{
            StackNode stackNode = new StackNode();
            stackNode.setData(i);
            linkedStack.push(stackNode);
        });
        /*StackNode stackNode = new StackNode();
        stackNode.setData(11);
        linkedStack.push(stackNode);*/
        //遍历栈
        linkedStack.list();
        //出栈
        System.out.println("我出栈啦："+linkedStack.pop().getData().toString());
        //遍历栈
        linkedStack.list();

    }
}

class LikedStack{
    //栈顶指针(相对于链表的头节点)
    private StackNode top = new StackNode();
    private int maxStackSize;
    private int size = 0;
    public LikedStack(int maxStackSize){
        this.maxStackSize = maxStackSize;
    }

    /**
     * 入栈
     * @param stackNode 栈对象
     */
    public void push(StackNode stackNode){
        if (isFull()){
            throw new IllegalArgumentException("栈已满，不能入栈");
        }
        ++size;
        stackNode.setNext(top.getNext());
        top.setNext(stackNode);
    }

    /**
     * 出栈
     * @return 栈对象
     */
    public StackNode pop(){
        if (isNull()){
            throw new NullPointerException("栈为空，不能出栈");
        }
        --size;
        StackNode temp = top.getNext();
        top.setNext(temp.getNext());
        temp.setNext(null);
        return temp;
    }

    /**
     * 遍历链表
     */
    public void list(){
        if (isNull()){
            System.out.println("栈为空");
        }
        StackNode temp = top;
        while (temp.getNext()!=null){
            temp = temp.getNext();
            System.out.println(temp.getData().toString());
        }
    }
    /**
     * 判断栈是否为空
     * @return true：空
     */
    private boolean isNull(){
        return top.getNext()==null;
    }

    /**
     * 判断栈是否满
     * @return true：满
     */
    private boolean isFull(){
        return size==maxStackSize;
    }

}
@Data
class StackNode{
    private Object data;
    private StackNode next;
}
