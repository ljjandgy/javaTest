package structure.linkedlist;

import lombok.*;

/**
 * 链表单个节点
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Node {
    @NonNull
    private Object data;
    private Node next;

    @Override
    public String toString(){
        return String.valueOf(data);
    }
}
