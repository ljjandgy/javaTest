package structure.doublelinkedlist;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 21
 * @className DoubleLinkedListDemo
 * @description
 * @date 2020-06-02 14:27:04
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //往链表中添加对象
        Stream.iterate(1,n->n+1).limit(10).forEach(no->{
            DoubleLinkedNode node = new DoubleLinkedNode(no);
            node.setData("我的编号是："+no);
            doubleLinkedList.addByNo(node);
        });
        //输出链表内容
        doubleLinkedList.list();
        //删除内容
        doubleLinkedList.deleteByNo(3);
        //更新内容
        doubleLinkedList.updateByNo(5,"我被更新了");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    /** 第一个节点 **/
    private DoubleLinkedNode first = new DoubleLinkedNode(0);
    /** 最后一个节点 **/
    private DoubleLinkedNode last;

    /**
     * 把节点添加到列表的末尾
     * @param node 需要添加的节点
     */
    public void addLast(DoubleLinkedNode node){
        DoubleLinkedNode temp = first.getNext();
        if (temp==null){
            this.first.setNext(node);
            node.setPrev(first);
            this.last = node;
            return;
        }
        while (true){
            if (temp.getNext()==null){
                temp.setNext(node);
                node.setPrev(temp);
                this.last = node;
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 通过编号添加节点（用于升序链表）
     * @param node 需要添加的节点
     */
    public void addByNo(DoubleLinkedNode node){
        DoubleLinkedNode temp = first;
        while (true){
            if (temp.getNext()==null){
                temp.setNext(node);
                node.setPrev(temp);
                last = node;
                break;
            }else if(temp.getNext().getNo()>=node.getNo()){
                node.setPrev(temp.getPrev());
                node.setNext(temp);
                temp.setPrev(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 根据编号删除节点
     * 采用从前向后遍历的方式，其实可以根据no和链表的length确定具体遍历方式（从前向后还是从后向前）
     * @param no 需要删除节点的编号
     */
    public void deleteByNo(int no){
        if (no==0){
            throw new IllegalArgumentException("不能删除头节点");
        }
        DoubleLinkedNode temp = first.getNext();
        if (temp==null){
            throw new NullPointerException("链表为空，不能删除");
        }
        while (true){
            if (temp.getNo()==no){
                //上个节点的下个节点设置为被删除节点的下个节点
                temp.getPrev().setNext(temp.getNext());
                //下个节点的上个节点设置为被删除节点的上个节点
                Optional.of(temp.getNext()).ifPresent(obj->obj.setPrev(obj.getPrev().getPrev()));
                if (temp.getNext()==null){
                    last = temp.getPrev();
                }
                break;
            }else if(temp.getNext()==null){
                //找到最好一个节点都没有匹配，则说明链表中不存在相应编号
                throw new NullPointerException("没有找到编号对应节点，无法删除");
            }
            temp = temp.getNext();
        }
    }

    /**
     * 更新特定节点的数据域
     * @param no 序号
     * @param data 需要更新的数据
     */
    public void updateByNo(int no,Object data){
        if (no==0){
            throw new IllegalArgumentException("不能更新头节点");
        }
        DoubleLinkedNode temp = first.getNext();
        if (temp==null){
            throw new NullPointerException("链表为空，不能更新");
        }
        while (true){
            if (temp.getNo()==no){
                //更新数据
               temp.setData(data);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 遍历整个双向链表
     */
    public void list(){
        DoubleLinkedNode temp = first.getNext();
        if (temp==null){
            throw new NullPointerException("链表为空，不能遍历");
        }
        while (temp.getNext()!=null){
            System.out.println(temp.getData().toString());
            temp = temp.getNext();
        }
        System.out.println(temp.getData().toString());
    }
}
