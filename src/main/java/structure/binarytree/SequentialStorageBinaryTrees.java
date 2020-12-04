package structure.binarytree;

/**
 * @author ljj
 * @version sprint 12
 * @className SequentialStorageBinaryTrees
 * @description
 * @date 2020-12-02 19:20:23
 */
public class SequentialStorageBinaryTrees {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        BinaryTreeNode root = getTree(array);
        //前序遍历
        TraverseBinaryTreeUtil.preTraverseBinaryTree(root);
    }

    private static BinaryTreeNode getTree(int[] array){
        if (array==null||array.length==0){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(array[0]);
        putNode(root,array,0);
        return root;
    }

    private static void putNode(BinaryTreeNode node,int[] array,int n){
        if (node!=null){
            int leftChildNum = 2*n+1;
            if (leftChildNum<=array.length-1){
                if (node.getLeft()==null){
                    node.setLeft(new BinaryTreeNode(array[leftChildNum]));
                }
                int rightChildNum = 2*n+2;
                if(rightChildNum<=array.length-1){
                    if (node.getRight()==null){
                        node.setRight(new BinaryTreeNode(array[rightChildNum]));
                    }
                }
                putNode(node.getLeft(),array,leftChildNum);
                putNode(node.getRight(),array,rightChildNum);
            }

        }
    }

}
