package structure.binarytree.thread;

import structure.binarytree.BinaryTreeNode;
import structure.binarytree.TraverseBinaryTreeUtil;

/**
 * @author ljj
 * @version sprint 12
 * @className ThreadBinaryTreeDemo
 * @description
 * @date 2020-12-07 11:33:33
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadBinaryTreeNode root = getTree();
        //TraverseBinaryTreeUtil.preTraverseBinaryTree(root);
        //TraverseBinaryTreeUtil.inTraverseBinaryTree(root);
        TraverseBinaryTreeUtil.postTraverseBinaryTree(root);
        System.out.println();
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree(root);
        /*threadBinaryTree.setPreThreadTree();
        threadBinaryTree.preTraverse();*/
        /*threadBinaryTree.setInThreadTree();
        threadBinaryTree.inTraverse();*/
        threadBinaryTree.setPostThreadTree();
        threadBinaryTree.postTraverse();
    }

    private static ThreadBinaryTreeNode getTree(){
        ThreadBinaryTreeNode root = new ThreadBinaryTreeNode(15);

        ThreadBinaryTreeNode binaryTreeNode1 = new ThreadBinaryTreeNode(25);
        ThreadBinaryTreeNode binaryTreeNode2 = new ThreadBinaryTreeNode(65);
        ThreadBinaryTreeNode binaryTreeNode3 = new ThreadBinaryTreeNode(44);
        ThreadBinaryTreeNode binaryTreeNode4 = new ThreadBinaryTreeNode(23);
        ThreadBinaryTreeNode binaryTreeNode5 = new ThreadBinaryTreeNode(12);
        ThreadBinaryTreeNode binaryTreeNode6 = new ThreadBinaryTreeNode(102);
        ThreadBinaryTreeNode binaryTreeNode7 = new ThreadBinaryTreeNode(86);

        root.setRight(binaryTreeNode1);
        root.setLeft(binaryTreeNode2);

        binaryTreeNode1.setLeft(binaryTreeNode3);
        binaryTreeNode1.setRight(binaryTreeNode4);

        binaryTreeNode2.setLeft(binaryTreeNode5);
        binaryTreeNode2.setRight(binaryTreeNode6);

        binaryTreeNode3.setLeft(binaryTreeNode7);
        return root;
    }
}
