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
    static void preTraverseBinaryTree(BinaryTreeNode node){
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
    static void inTraverseBinaryTree(BinaryTreeNode node){
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
    static void postTraverseBinaryTree(BinaryTreeNode node){
        if (node!=null){
            //先遍历左子树，找到最左子树的左叶子节点
            inTraverseBinaryTree(node.getLeft());
            //遍历当前子树根节点的右子树
            inTraverseBinaryTree(node.getRight());
            //输出节点值
            System.out.print(node.getValue()+"->");
        }
    }

    /**
     * 前序遍历查找节点
     * @param node 节点
     * @param target 目标值
     */
    static BinaryTreeNode preTraverseSearch(BinaryTreeNode node,int target){
        if (node!=null){
            if (target == node.getValue()){
                return node;
            }
            BinaryTreeNode resultNode;
            resultNode = preTraverseSearch(node.getLeft(),target);
            if (resultNode==null){
                resultNode = preTraverseSearch(node.getRight(),target);
            }
            return resultNode;
        }
        return null;
    }

    /**
     * 中序遍历查找二叉树
     * @param node 二叉树节点
     * @param target 目标
     * @return 满足要求的二叉树节点
     */
    static BinaryTreeNode inTraverseSearch(BinaryTreeNode node,int target){
        if (node!=null){
            BinaryTreeNode resultNode;
            resultNode = inTraverseSearch(node.getLeft(),target);
            if (node.getValue() == target){
                return node;
            }
            if (resultNode == null){
                resultNode = inTraverseSearch(node.getRight(),target);
            }
            return resultNode;
        }
        return null;
    }

    /**
     * 后序遍历查找二叉树
     * @param node 二叉树节点
     * @param target 目标
     * @return 符合要求的节点
     */
    static BinaryTreeNode postTraverseSearch(BinaryTreeNode node,int target){
        if (node!=null){
            BinaryTreeNode resultNode;
            resultNode = postTraverseSearch(node.getLeft(),target);
            if (resultNode==null){
                resultNode = postTraverseSearch(node.getRight(),target);
            }
            if (node.getValue() == target){
                return node;
            }
            return resultNode;
        }
        return null;
    }
}
