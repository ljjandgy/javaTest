package structure.binarytree.thread;

import lombok.Data;
import lombok.NoArgsConstructor;
import structure.binarytree.BinaryTreeNode;

/**
 * @author ljj
 * @version sprint 12
 * @className ThreadBinaryTreeNode
 * @description
 * @date 2020-12-07 19:25:18
 */
@Data
@NoArgsConstructor
public class ThreadBinaryTreeNode extends BinaryTreeNode{
    private boolean ifLeftThread;

    private boolean ifRightThread;

    public ThreadBinaryTreeNode(int value){
        super(value);
    }
}
