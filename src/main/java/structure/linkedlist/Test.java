package structure.linkedlist;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(1);
        System.out.println(linkedList.toString());
    }
}
