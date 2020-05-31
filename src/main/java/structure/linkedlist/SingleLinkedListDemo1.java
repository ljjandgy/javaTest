package structure.linkedlist;

/**
 * 通过把新对象都放到链表后面实现的创建
 */
public class SingleLinkedListDemo1 {

    public static void main(String[] args) {
        InitSingleLinkedList linkedList = new InitSingleLinkedList();
        linkedList.add(new Node("first"));
        linkedList.add(new Node("second"));
        linkedList.add(new Node("third"));
        linkedList.add(new Node("forth"));
        //查看所有元素
        linkedList.list();
        //删除最后的节点
        linkedList.remove();
        //查看所有元素
        linkedList.list();
    }
}

class InitSingleLinkedList{
    //定义头结点，头结点的数据域为空
    private Node headNode = new Node("");
    /**
     * 添加节点
     * @param node 需要添加的节点对象
     */
    public void add(Node node){
        //定义指针，首先指向头结点
        Node temp = headNode;
        while (true){
            //找到了链表最后就跳出循环
            if (temp.getNext()==null){
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 遍历链表，输出链表内容
     */
    public void list(){
        if (headNode.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        Node temp = headNode;
        while (true){
            System.out.println(temp.toString());
            //到了队尾就跳出循环
            if (temp.getNext()==null){
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 删除单链表最后一个节点
     */
    public void remove(){
        if (headNode.getNext()==null){
            System.out.println("链表为空，不能删除");
            return;
        }
        Node temp = headNode;
        while (true){
            //如果本身有下一个节点，但是下一个点是最后一个节点时，就把最后一个节点的连接断开
            if (temp.getNext()!=null&&temp.getNext().getNext()==null){
                temp.setNext(null);
                break;
            }
            temp = temp.getNext();
        }
    }
}
