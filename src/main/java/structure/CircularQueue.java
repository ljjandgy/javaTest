package structure;

/**
 * @author ljj
 * @version sprint 21
 * @className CircularQueue
 * @description 环形队列
 * @date 2020-05-19 19:39:49
 */
public class CircularQueue<T> {
    /**
     * 整体设计思路：
     * 1.在基本队列的基础上调至front和rear的定义，front指向队列第一个元素，而rear指向队列的最后一个元素-1，并且初始值都是0
     * 2.此时，队列满的判断依据是：(rear+1)%maxSize=front,也就是队尾和队首连在一起了
     * 3.队列空的判断条件和之前一致为rear=front，因为rear现在指向的是队尾的后一位，是预留的空空间，所以一旦front指向了一个空的空间，那么说明队列中的所有元素都被取走了
     * 4.队列中有效数据的判断条件为（rear+maxSize-front）%maxSize
     */
    private int maxSize = 0;
    private T[] array;
    /** 队首指针 **/
    private int front;
    /** 队尾指针 **/
    private int rear;
    public CircularQueue(int maxSize){
        this.maxSize = maxSize;
        array = (T[])new Object[maxSize];
        //初始化队首指针
        front = 0;
        //初始化队尾指针
        rear = 0;
    }

    /**
     * 向队列中添加元素
     */
    public void add(T obj){
        //先移动队尾指针,其实这种设计下rear和front指针的含义是一致的，都是表示下一个可以操作的数组位置
        if (!isFull()){
           /*
              array[rear]=obj;
              ++rear
              if(rear==maxSize){
                   rear = 0;
              }
            */
           array[rear] = obj;
           rear = (rear+1)%maxSize;
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
            T obj = array[front];
            /*++front;
            if (front==maxSize){
                front = 0;
                return array[0];
            }*/
            front = (front+1)%maxSize;
            return obj;
        }else{
            throw new RuntimeException("队列为空，不能取值");
        }
    }

    /**
     * 判断队列是否已满
     * @return true：满
     */
    public boolean isFull(){
        return this.rear%this.maxSize==this.front;
    }

    /**
     * 判断队列是否为空
     * @return true：空
     */
    public boolean isNull(){
        return this.front==this.rear;
    }

    /**
     * 展示队列中的元素
     */
    public void showQueue(){
        for (int i=front;i<getQueueSize();i++){
            System.out.printf("下标为：%s，对应的元素内容为：%s",i%maxSize,array[i%maxSize]);
        }
    }
    /**
     * 获取队列中剩余元素个数
     * @return 元素个数
     */
    public int getQueueSize(){
        /**
         * 其实这个地方包含了三种种情况，分别是rear>front、rear小于front和两者相等
         * 当rear>front时，包含的元素个数为rear-front
         * 当rear<front时，包含的元素个数为rear+(maxSize-front)
         * 当rear=front时，为0
         * 三个算法整合，就是下面的计算公式
         * 当rear+maxSize-front>maxSize时，其可以等价为rear+maxSize-front-maxSize对应rear>front的情况
         * 当rear+maxSize-front<maxSize时，其可以登记为rear+maxSize-fron对应rear<front的情况
         */
        return (rear+maxSize-front)%maxSize;
    }

}
