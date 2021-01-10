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

    /**
     * 获取当前节点的左子树的高度
     * @return 左子树的高度
     */
    public int getLeftChildTreeHeight(){
        //空树高度为-1
        if (this.left==null){
            return -1;
        }
        return this.left.getTreeHeight();
    }

    /**
     * 获取当前节点右子树的高度
     * @return 右子树的高度
     */
    public int getRightChildTreeHeight(){
        //空树高度为-1
        if (this.right==null){
            return -1;
        }
        return this.right.getTreeHeight();
    }

    /**
     * 获取以当前节点为树的高度
     * 树的高度为当前节点到叶子节点的最长路径，且叶子节点的高度为0
     */
    public int getTreeHeight(){
        return Math.max(this.left == null?0:this.left.getTreeHeight()+1,this.right == null ? 0 : this.right.getTreeHeight()+1);
    }
}
