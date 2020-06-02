package structure.doublelinkedlist;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author ljj
 * @version sprint 21
 * @className DoubleLinkedNode
 * @description
 * @date 2020-06-02 14:25:58
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class DoubleLinkedNode {
    @NonNull
    private int no;
    private Object data;
    private DoubleLinkedNode prev;
    private DoubleLinkedNode next;


    @Override
    public String toString() {
        return "我被调用了";
    }
}
