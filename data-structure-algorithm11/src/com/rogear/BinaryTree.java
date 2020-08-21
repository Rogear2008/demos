package com.rogear;

/**
 * 二叉树
 * Created by Rogear on 2020/8/18
 **/
public class BinaryTree {

    private TreeNode root = null;

    public BinaryTree(){
        root = new TreeNode(1,"A");
    }

    /**
     * 二叉树节点
     */
    public class TreeNode{
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    /**
     * 构建一个二叉树
     *         A
     *     B        C
     *  D     E        F
     */
    public void createBinatryTree(){
        TreeNode nodeB = new TreeNode(2,"B");
        TreeNode nodeC = new TreeNode(3,"C");
        TreeNode nodeD = new TreeNode(4,"D");
        TreeNode nodeE = new TreeNode(5,"E");
        TreeNode nodeF = new TreeNode(6,"F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(TreeNode node){
        if (node == null){
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return (i<j)?j+1:i+1;
        }
    }

//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.createBinatryTree();
//        int height = binaryTree.getHeight();
//        System.out.println("height:" + height);
//    }

    public static void main(String[] args) {
        System.out.println("123");
    }
}
