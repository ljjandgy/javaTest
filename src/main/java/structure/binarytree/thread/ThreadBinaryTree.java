package structure.binarytree.thread;

import lombok.Data;

/**
 * @author ljj
 * @version sprint 12
 * @className ThreadBinaryTree
 * @description
 * @date 2020-12-08 14:26:12
 */
public class ThreadBinaryTree {
    private ThreadBinaryTreeNode root;
    /** 前驱指针，构建线索二叉树时使用 **/
    private ThreadBinaryTreeNode preNode;

    public ThreadBinaryTree(ThreadBinaryTreeNode root){
        this.root = root;
    }

    public void setPreThreadTree(){
        preThreadNode(this.root);
    }

    public void setInThreadTree(){
        inThreadNode(this.root);
    }
    public void setPostThreadTree(){
        postThreadNode(this.root);
    }

    /**
     * 通过先序遍历线索化二叉树
     */
    private void preThreadNode(ThreadBinaryTreeNode node){
        if (node!=null){
            //线索节点先序指针赋值
            if (node.getLeft()==null){
                node.setLeft(preNode);
                node.setIfLeftThread(Boolean.TRUE);
            }
            //线索节点后续指针赋值
            if (preNode!=null&&preNode.getRight()==null){
                preNode.setRight(node);
                preNode.setIfRightThread(Boolean.TRUE);
            }
            preNode = node;
            if (!node.isIfLeftThread()){
                preThreadNode((ThreadBinaryTreeNode) node.getLeft());
            }
            if (!node.isIfRightThread()){
                preThreadNode((ThreadBinaryTreeNode)node.getRight());
            }
        }
    }

    public void preTraverse(){
        System.out.print(root.getValue()+"->");
        ThreadBinaryTreeNode node = (ThreadBinaryTreeNode)root.getLeft();
        if (node==null){
            node = (ThreadBinaryTreeNode)root.getRight();
        }
        while (node.getRight()!=null){
            System.out.print(node.getValue()+"->");
            //通用逻辑，只要右子树是线索，就直接遍历右子树即可
            if (node.isIfRightThread()){
                node = (ThreadBinaryTreeNode)node.getRight();
            }else{
                node = (ThreadBinaryTreeNode)node.getLeft();
            }
        }
        System.out.print(node.getValue());
    }
    /**
     * 通过中序遍历线索化二叉树
     */
    private void inThreadNode(ThreadBinaryTreeNode node){
        if (node!=null){
            inThreadNode((ThreadBinaryTreeNode) node.getLeft());
            //线索节点先序指针赋值
            if (node.getLeft()==null){
                node.setLeft(preNode);
                node.setIfLeftThread(Boolean.TRUE);
            }
            //线索节点后续指针赋值
            if (preNode!=null&&preNode.getRight()==null){
                preNode.setRight(node);
                preNode.setIfRightThread(Boolean.TRUE);
            }
            preNode = node;
            inThreadNode((ThreadBinaryTreeNode)node.getRight());
        }
    }

    /**
     * 中序遍历线索树
     */
    public void inTraverse(){
        ThreadBinaryTreeNode node = root;
        if (node != null) {
            while (!node.isIfLeftThread()) {
                // 如果左孩子不是线索
                node = (ThreadBinaryTreeNode) node.getLeft();
            }
            do {
                System.out.print(node.getValue() + "->");
                if (node.isIfRightThread()) {
                    // 如果右孩子是线索
                    node = (ThreadBinaryTreeNode)node.getRight();
                } else {
                    // 有右孩子
                    node = (ThreadBinaryTreeNode)node.getRight();
                    while (node != null && !node.isIfLeftThread()) {
                        node = (ThreadBinaryTreeNode)node.getLeft();
                    }
                }
            } while (node != null);
        }
    }

    /**
     * 通过后序遍历生成线索树
     * @param node 线索树节点
     */
    private void postThreadNode(ThreadBinaryTreeNode node){
        if (node!=null){
            postThreadNode((ThreadBinaryTreeNode)node.getLeft());
            postThreadNode((ThreadBinaryTreeNode)node.getRight());
            if (node.getLeft()==null){
                node.setLeft(preNode);
                node.setIfLeftThread(Boolean.TRUE);
            }
            if (preNode!=null&&preNode.getRight()==null){
                preNode.setRight(node);
                preNode.setIfRightThread(Boolean.TRUE);
            }
            preNode = node;
        }
    }
    public void postTraverse(){
        postTraverse(this.root);
    }
    private void postTraverse(ThreadBinaryTreeNode node){
        if (node!=null){
            if (node.isIfLeftThread()&&node.isIfRightThread()){
                System.out.print(node.getValue()+"->");
                ThreadBinaryTreeNode temp = (ThreadBinaryTreeNode)node.getRight();
                while (temp!=null&&temp.isIfRightThread()){
                    System.out.print(temp.getValue()+"->");
                    temp = (ThreadBinaryTreeNode)temp.getRight();
                }
                System.out.print(temp.getValue()+"->");
            }else{
                postTraverse((ThreadBinaryTreeNode)node.getLeft());
                //只有右节点为非线索节点时，才需要向下递归，否则都已经被左节点的线索节点遍历到了
                if (node.getRight()!=null&&!((ThreadBinaryTreeNode)node.getRight()).isIfRightThread()){
                    postTraverse((ThreadBinaryTreeNode)node.getRight());
                    //有有节点，并且右节点不为线索说明其不会因为线索而被遍历到，否则就会因为右线索被遍历到，就不用通过递归再去遍历它了
                    System.out.print(node.getValue()+"->");
                }
            }
        }
        }
}
