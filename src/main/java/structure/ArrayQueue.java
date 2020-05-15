package structure;

/**
 * @author ljj
 * @version sprint 21
 * @className ArrayQueue
 * @description
 * @date 2020-05-14 20:28:36
 */
public class ArrayQueue<T> {
    private int maxSize = 0;
    private T[] array;
    /** 队首指针 **/
    private int front;
    /** 队尾指针 **/
    private int rear;
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        array = (T[])new Object[maxSize];
        //初始化队首指针
        front = -1;
        //初始化队尾指针
        rear = -1;
    }

    /**
     * 向队列中添加元素
     * 如果rear=front则队列空，可以添加，如果rear<maxSize-1，队列未满可以添加。
     * 如果rear==maxSize-1，队列满，不可添加
     */
    public void add(T obj){
        //先移动队尾指针
        if (!isFull()){
            ++rear;
            array[rear] = obj;
        }else{
            throw new RuntimeException("队列已满，不能添加");
        }
    }

    /**
     * 从队列中取元素，只有队列有值时才能取
     */
    public T get(){
        if (!isNull()){
            //先移动队首指针
            ++front;
            return array[front];
        }else{
            throw new RuntimeException("队列为空，不能取值");
        }
    }

    /**
     * 判断队列是否已满
     * @return true：满
     */
    public boolean isFull(){
        return this.maxSize-1==this.rear;
    }

    /**
     * 判断队列是否为空
     * @return true：空
     */
    public boolean isNull(){
        return this.front==this.rear;
    }
}
