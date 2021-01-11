package structure.binarytree.avl;

import structure.binarytree.BinaryTreeNode;
import structure.binarytree.TraverseBinaryTreeUtil;

/**
 * AVL树demo
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //左旋测试
        int[] leftRotateTestArray = {4,3,6,5,7,8};
        //当一个节点的右子树的高度比左子树高度大1时，就说明需要依靠右旋来构成AVL树
        BinaryTreeNode root = new BinaryTreeNode(leftRotateTestArray[0]);
        for (int i = 1;i<leftRotateTestArray.length;++i){
            putNode(root,leftRotateTestArray[i]);
        }
        //前序遍历
        TraverseBinaryTreeUtil.preTraverseBinaryTree(root);
        System.out.println();

        //右旋测试
        int[] rightRotateTestArray = {10,12,8,9,7,6};
        BinaryTreeNode root1 = new BinaryTreeNode(rightRotateTestArray[0]);
        for (int i = 1;i<rightRotateTestArray.length;++i){
            putNode(root1,rightRotateTestArray[i]);
        }
        //前序遍历
        TraverseBinaryTreeUtil.preTraverseBinaryTree(root1);
        System.out.println();
        //双旋测试
        int[] allRotateTestArray1 = {10,11,7,6,8,9};
        int[] allRotateTestArray2 = {2,1,6,5,7,3};
        BinaryTreeNode root2 = new BinaryTreeNode(allRotateTestArray1[0]);
        for (int i = 1;i<allRotateTestArray1.length;++i){
            putNode(root2,allRotateTestArray1[i]);
        }
        //前序遍历
        TraverseBinaryTreeUtil.preTraverseBinaryTree(root2);
        System.out.println();
        BinaryTreeNode root3 = new BinaryTreeNode(allRotateTestArray2[0]);
        for (int i = 1;i<allRotateTestArray2.length;++i){
            putNode(root3,allRotateTestArray2[i]);
        }
        //前序遍历
        TraverseBinaryTreeUtil.preTraverseBinaryTree(root3);
        System.out.println();
    }


    /**
     * 单次AVL左旋操作主要分为6步：
     * 1.创建一个新的节点，节点值和node节点一致
     * 2.新节点的左子树设置为node节点的左子树
     * 3.新节点的右子树为node节点右子树的左子树
     * 4.把node节点的值替换为右子节点的值
     * 5.把node节点的右子树设置为node节点的右子树的右子树（删除node节点的右子节点）
     * 6.把node节点的左子节点设置为新建的节点
     * @param node node需要进行左旋的树的根节点
     */
    public static void leftRotate(BinaryTreeNode node){
        BinaryTreeNode newNode = new BinaryTreeNode(node.getValue());
        newNode.setLeft(node.getLeft());
        newNode.setRight(node.getRight().getLeft());
        node.setValue(node.getRight().getValue());
        node.setRight(node.getRight().getRight());
        node.setLeft(newNode);
    }

    /**
     * 单次AVL树右旋操作和左旋操作很类似，也分为6步：
     * 1.创建一个新的节点，节点值和node节点一致
     * 2.新节点的右子树设置为node节点的右子树
     * 3.新节点的左子树为node节点左子树的右子树
     * 4.把node节点的值替换为左子节点的值
     * 5.把node节点的左子树设置为node节点的左子树的左子树（删除node节点的左子节点，减少左子树高度）
     * 6.把node节点的右子节点设置为新建的节点
     * @param node 需要进行右旋的节点
     */
    public static void rightRotate(BinaryTreeNode node){
        BinaryTreeNode newNode = new BinaryTreeNode(node.getValue());
        newNode.setRight(node.getRight());
        newNode.setLeft(node.getLeft().getRight());
        node.setValue(node.getLeft().getValue());
        node.setLeft(node.getLeft().getLeft());
        node.setRight(newNode);
    }

    private static void putNode(BinaryTreeNode node,int value){
        if (node!=null){
            if (node.getValue()>value){
                putNode(node.getLeft(),value);
                //只有当相应子树为空时才进行赋值
                if (node.getLeft()==null){
                    node.setLeft(new BinaryTreeNode(value));
                }
            }else{
                putNode(node.getRight(),value);
                //只有当相应子树为空时才进行赋值
                if (node.getRight()==null){
                    node.setRight(new BinaryTreeNode(value));
                }
            }
            //当右子树的高度比左子树高度大1时，进行左旋
            if (node.getRightChildTreeHeight()-node.getLeftChildTreeHeight()>1){
                //当要进行左旋时，还需要判断其右子树的左子树高度是否大于右子树高度。如果大于，则需要先对node节点的右子树进行右旋，防止node节点左旋后仍然不平衡
                if (node.getRight().getLeftChildTreeHeight()>node.getRight().getRightChildTreeHeight()){
                    rightRotate(node.getRight());
                }
                leftRotate(node);
            }else if(node.getLeftChildTreeHeight()-node.getRightChildTreeHeight()>1){
                //当左子树的高度比右子树高度大1时，进行右旋
                //当要进行右旋时，还需要判断其左子树的右子树高度是否大于左子树高度。如果大于，则需要先对node节点的左子树进行左旋，防止node节点右旋后仍然不平衡
                if (node.getLeft().getRightChildTreeHeight()>node.getLeft().getLeftChildTreeHeight()){
                    leftRotate(node.getLeft());
                }
                rightRotate(node);
            }

        }
    }
}
