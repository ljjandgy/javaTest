package structure.binarytree;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ljj
 * @version sprint 12
 * @className BinaryTreeNode
 * @description
 * @date 2020-11-23 20:02:02
 */
@Data
@NoArgsConstructor
public class BinaryTreeNode {
    private BinaryTreeNode left;

    private BinaryTreeNode right;

    private int value;

    public BinaryTreeNode(int value){
        this.value = value;
    }
}
