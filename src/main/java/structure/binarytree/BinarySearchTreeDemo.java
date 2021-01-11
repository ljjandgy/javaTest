package structure.binarytree;

import structure.linkedlist.Node;

import static structure.binarytree.TraverseBinaryTreeUtil.inTraverseBinaryTree;
import static structure.binarytree.TraverseBinaryTreeUtil.inTraverseSearch;
import static structure.binarytree.TraverseBinaryTreeUtil.postTraverseBinaryTree;
import static structure.binarytree.TraverseBinaryTreeUtil.postTraverseSearch;
import static structure.binarytree.TraverseBinaryTreeUtil.preTraverseBinaryTree;
import static structure.binarytree.TraverseBinaryTreeUtil.preTraverseSearch;

/**
 * @author ljj
 * @version sprint 12
 * @className BinarySearchTreeDemo
 * @description
 * @date 2020-11-24 17:33:51
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        int[] testArray = {25,5,55,23,34,44,66,77,13,8,14,606};
        BinaryTreeNode root = getBinarySearchTree(testArray);
        //先序遍历
        System.out.println("先序遍历：");
        preTraverseBinaryTree(root);
        //中序遍历
        System.out.println("\n中序遍历：");
        inTraverseBinaryTree(root);
        //后序遍历
        System.out.println("\n后序遍历：");
        postTraverseBinaryTree(root);

        System.out.println();
        int target = 44;
        //在二叉树中利用前序遍历查找对象
        BinaryTreeNode preTargetNode = preTraverseSearch(root,target);
        System.out.println(preTargetNode);
        //在二叉树中利用中序遍历查找对象
        BinaryTreeNode inTargetNode = inTraverseSearch(root,target);
        System.out.println(inTargetNode);
        //后序遍历查找对象
        BinaryTreeNode postTargetNode = postTraverseSearch(root,target);
        System.out.println(postTargetNode);

        //删除单子树节点
        deleteNode(root,55);
        //前序遍历新树
        preTraverseBinaryTree(root);
        System.out.println();
        //删除叶子节点
        deleteNode(root,44);
        //前序遍历新树
        preTraverseBinaryTree(root);
        System.out.println();
        //删除双子树节点
        deleteNode(root,13);
        //前序遍历新树
        preTraverseBinaryTree(root);
        System.out.println();
        //删除根节点
        deleteNode(root,25);
        //前序遍历新树
        preTraverseBinaryTree(root);
    }

    private static BinaryTreeNode getBinarySearchTree(int[] array){
        if (array==null){
            throw new NullPointerException("数组为空");
        }
        BinaryTreeNode root = new BinaryTreeNode(array[0]);
        //在创建二叉查找数时，需要不断的和当前树的根节点做比较
        for (int i=1;i<array.length;++i){
            putNode(root,array[i]);
        }
        return root;
    }

    private static void putNode(BinaryTreeNode node,int value){
        if (node!=null){
            if (node.getValue()>value){
                putNode(node.getLeft(),value);
                //只对叶子节点进行操作
                if (node.getLeft()==null){
                    node.setLeft(new BinaryTreeNode(value));
                }
            }else{
                putNode(node.getRight(),value);
                //只对叶子节点进行操作
                if (node.getRight()==null){
                    node.setRight(new BinaryTreeNode(value));
                }
            }
        }
    }

    /**
     * 删除目标节点
     * @param targetValue 目标值
     */
    private static void deleteNode(BinaryTreeNode root,int targetValue){
        if (targetValue==root.getValue()){
            doDeleteNode(null,root);
            return;
        }
        //获取要删除节点的父节点
        BinaryTreeNode parent = getParentNode(root,targetValue);
        if (parent==null){
            throw new IllegalArgumentException("未找到需要删除的节点");
        }
        if (parent.getLeft()!=null&&parent.getLeft().getValue()==targetValue){
            doDeleteNode(parent,parent.getLeft());
        }else{
            doDeleteNode(parent,parent.getRight());
        }
    }

    /**
     * 删除节点
     * @param parentNode 目标节点的父节点
     * @param targetNode 目标节点是否是左节点
     */
    private static void doDeleteNode(BinaryTreeNode parentNode,BinaryTreeNode targetNode){
        //当父节点为null，说明要删除的是root节点
        if (parentNode==null){
            BinaryTreeNode minNode = getMinNode(targetNode);
            targetNode.setValue(minNode.getValue());
            return;
        }
        //删除叶子节点时，直接删除即可
        if (targetNode.getLeft()==null&&targetNode.getRight()==null){
            if (parentNode.getLeft()!=null&&parentNode.getLeft().getValue() == targetNode.getValue()){
                parentNode.setLeft(null);
            }else{
                parentNode.setRight(null);
            }
        }else if (targetNode.getLeft()!=null&&targetNode.getRight()!=null){
            targetNode.setValue(getMinNode(targetNode).getValue());
        }else{
            //有一棵子树时，只需要用目标节点的子节点去替代目标节点即可
            if (parentNode.getLeft()!=null&&parentNode.getLeft().getValue() == targetNode.getValue()){
                if (targetNode.getRight()!=null){
                    parentNode.setLeft(targetNode.getRight());
                }else{
                    parentNode.setLeft(targetNode.getLeft());
                }
            }else{
                if (targetNode.getRight()!=null){
                    parentNode.setRight(targetNode.getRight());
                }else{
                    parentNode.setRight(targetNode.getLeft());
                }
            }
        }
    }

    /**
     * 获取右子树中最小节点，其实也就是获取右子树中最左子树，也就是不会有左子树的子树
     * @param targetNode 需要删除的目标节点
     * @return 右子树中的最小节点
     */
    private static BinaryTreeNode getMinNode(BinaryTreeNode targetNode){
        BinaryTreeNode rightNode = targetNode.getRight();
        //维护一个父指针，方便删除
        BinaryTreeNode parent = targetNode;
        BinaryTreeNode node = rightNode;
        while (node.getLeft()!=null){
            parent = node;
            node = node.getLeft();
        }
        //右子树中的最左子树为右子树中的最小值,找到后，删除该节点
        doDeleteNode(parent,node);
        return node;
    }

    /**
     * 获取目标值的父节点
     * @param node 当前树的根节点
     * @param targetValue 目标值
     * @return
     */
    private static BinaryTreeNode getParentNode(BinaryTreeNode node,int targetValue){
        if ((node.getLeft()!=null&&node.getLeft().getValue()==targetValue)
                ||(node.getRight()!=null&&node.getRight().getValue()==targetValue)){
            return node;
        }
        if (node.getLeft()!=null&&node.getValue()>targetValue){
            return getParentNode(node.getLeft(),targetValue);
        }else if(node.getRight()!=null&&node.getValue()<targetValue){
            return getParentNode(node.getRight(),targetValue);
        }else{
            return null;
        }
    }
}
