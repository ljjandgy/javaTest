package structure.binarytree;

import sun.plugin2.message.GetAppletMessage;

import static structure.binarytree.TraverseBinaryTreeUtil.inTraverseBinaryTree;
import static structure.binarytree.TraverseBinaryTreeUtil.postTraverseBinaryTree;
import static structure.binarytree.TraverseBinaryTreeUtil.preTraverseBinaryTree;

/**
 * @author ljj
 * @version sprint 12
 * @className BinaryTreeDemo
 * @description
 * @date 2020-11-23 20:23:12
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //手动创建二叉树
        BinaryTreeNode root = getBinaryTree();
        //先序遍历
        System.out.println("先序遍历：");
        preTraverseBinaryTree(root);
        //中序遍历
        System.out.println("\n中序遍历：");
        inTraverseBinaryTree(root);
        //后序遍历
        System.out.println("\n后序遍历：");
        postTraverseBinaryTree(root);
    }

    private static BinaryTreeNode getBinaryTree(){
        BinaryTreeNode root = new BinaryTreeNode();
        root.setValue(15);


        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.setValue(12);

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.setValue(22);

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.setValue(56);

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.setValue(88);

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.setValue(75);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setRight(node5);

        return root;
    }


}
