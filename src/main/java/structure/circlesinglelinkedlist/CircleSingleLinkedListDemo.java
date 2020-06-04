package structure.circlesinglelinkedlist;

import structure.doublelinkedlist.DoubleLinkedNode;

import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 21
 * @className CircleSingleLinkedListDemo
 * @description
 * @date 2020-06-03 19:37:12
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //往链表中添加对象
        Stream.iterate(1, n->n+1).limit(10).forEach(no->{
            CircleSingleLinkedListNode node = new CircleSingleLinkedListNode(no);
            node.setData("我的编号是："+no);
            circleSingleLinkedList.add(node);
        });
        //查看所有内容
        circleSingleLinkedList.list();
        //利用构建好的环形链表处理约瑟夫问题,假如k=2，m=3，n=11
        /**
         * 解题思路（双指针法）：
         * 1.构建两个指针，一个为first指针，指向第一个节点，一个为helper，指向最后一个节点（helper的next为first）
         * 2.让first指针和helper指针都向前移动k-1，让first指针指向开始报数的节点（准备从k节点开始报数）
         * 3.让first指针和helper指针都向前移动m-1次，删除first指针对应节点，让first指针指向next节点（报数报到m的人出圈）
         * 4.重复第三部，直到helper指针和first指针指向同一个的对象时，代表环形链表只剩下一个元素，操作停止。
         */
        //因为环形链表自带first指针，所以现在只需要定义helper指针即可，helper指针最大作用在于辅助接点的删除
        CircleSingleLinkedListNode helper = circleSingleLinkedList.first;
        while (helper.getNext()!=circleSingleLinkedList.first){
            helper = helper.getNext();
        }
        //移动helper和first指针k-1次
        for (int i=1;i<2;i++){
            circleSingleLinkedList.first = circleSingleLinkedList.first.getNext();
            helper = helper.getNext();
        }
        //开始报数，出圈
        while (helper != circleSingleLinkedList.first) {
            for (int i = 1; i < 3; i++) {
                circleSingleLinkedList.first = circleSingleLinkedList.first.getNext();
                helper = helper.getNext();
            }
            System.out.println("我出圈了：" + circleSingleLinkedList.first.getNo());
            //报数到m的对象出圈
            circleSingleLinkedList.first = circleSingleLinkedList.first.getNext();
            helper.setNext(circleSingleLinkedList.first);
        }
        System.out.println("我活到了最后："+helper.getNo());

    }
}
class CircleSingleLinkedList{
    /** 定义头结点指针,方便新加入的对象的next域指向头节点 **/
    public CircleSingleLinkedListNode first = null;

    public void add(CircleSingleLinkedListNode node){
        if (node.getNo()<1){
            throw new IllegalArgumentException("编号不能小于1");
        }
        if (first==null){
            //自己和自己形成环
            first = node;
            node.setNext(first);
            return;
        }
        //用于指向当前对象
        CircleSingleLinkedListNode temp = first;
        while (true){
            if (temp.getNext().getNo()>=node.getNo()){
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            }else if(temp.getNext()==first){
                temp.setNext(node);
                node.setNext(first);
                break;
            }
            temp = temp.getNext();
        }
    }

    public void delete(int no){
        //用于指向当前对象
        CircleSingleLinkedListNode temp = first;
        while (temp.getNo()!=no){
            if (temp.getNext()==first){
                throw new NullPointerException("未找到编号对应节点");
            }
            if (temp.getNext().getNo()==no){
                break;
            }
            temp = temp.getNext();
        }
        //删除next节点
        temp.setNext(temp.getNext().getNext());
    }

    public void list(){
        //用于指向当前对象
        CircleSingleLinkedListNode temp = first;
        while (true){
            System.out.println(temp.getData().toString());
            if (temp.getNext()==first){
                break;
            }
            temp = temp.getNext();
        }
    }
}
