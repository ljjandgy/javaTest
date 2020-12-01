package structure.binarytree;

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


}
