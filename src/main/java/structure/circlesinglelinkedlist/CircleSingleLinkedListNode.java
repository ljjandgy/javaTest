package structure.circlesinglelinkedlist;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author ljj
 * @version sprint 21
 * @className CircleSingleLinkedListNode
 * @description
 * @date 2020-06-03 19:34:48
 */
@Data
@RequiredArgsConstructor
public class CircleSingleLinkedListNode {
    @NonNull
    private int no;
    private Object data;
    private CircleSingleLinkedListNode next;
}
