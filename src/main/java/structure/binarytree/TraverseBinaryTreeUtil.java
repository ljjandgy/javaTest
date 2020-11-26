package structure.binarytree;

/**
 * @author ljj
 * @version sprint 12
 * @className TraverseBinaryTreeUtil
 * @description
 * @date 2020-11-24 17:50:05
 */
public class TraverseBinaryTreeUtil {
    private TraverseBinaryTreeUtil(){}

    /**
     * 先序遍历 根->左子树->右子树
     * @param node 树节点对象
     */
    public static void preTraverseBinaryTree(BinaryTreeNode node){
        if (node!=null){
            System.out.print(node.getValue()+"->");
            //左节点
            preTraverseBinaryTree(node.getLeft());
            //右节点
            preTraverseBinaryTree(node.getRight());
        }
    }

    /**
     * 中序遍历 左子树->根->右子树
     * @param node 树节点
     */
    public static void inTraverseBinaryTree(BinaryTreeNode node){
        if (node!=null){
            //先遍历左子树，找到最左子树的左叶子节点
            inTraverseBinaryTree(node.getLeft());
            //输出节点值
            System.out.print(node.getValue()+"->");
            //遍历当前子树根节点的右子树
            inTraverseBinaryTree(node.getRight());
        }
    }

    /**
     * 后序遍历 左子树->右子树->根
     * @param node 树节点
     */
    public static void postTraverseBinaryTree(BinaryTreeNode node){
        if (node!=null){
            //先遍历左子树，找到最左子树的左叶子节点
            inTraverseBinaryTree(node.getLeft());
            //遍历当前子树根节点的右子树
            inTraverseBinaryTree(node.getRight());
            //输出节点值
            System.out.print(node.getValue()+"->");
        }
    }
}
