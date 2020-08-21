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
     * 二叉树结点
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
     * 创建二叉树
     *         A
     *     B        C
     *  D     E          F
     */
    public void createBinaryTree(){
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

    /**
     * 求二叉树的高
     * @return
     */
    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null){
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return i>j?i+1:j+1;
        }
    }

    /**
     * 获取二叉树的结点数
     * @return
     */
    public int getSize(){
        return getSize(root);
    }

    private int getSize(TreeNode node) {
        if (node == null){
            return 0;
        } else {
            return getSize(node.leftChild)+getSize(node.rightChild)+1;
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(TreeNode node){
        if (node == null){
            return;
        } else {
            System.out.println("preOrder data:" + node.getData());
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midOrder(TreeNode node){
        if (node == null){
            return;
        } else {
            midOrder(node.leftChild);
            System.out.println("midOrder data:" + node.getData());
            midOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(TreeNode node){
        if (node == null){
            return;
        } else {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println("postOrder data:" + node.getData());
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        int height = binaryTree.getHeight();
        System.out.println("二叉树的高度为：" + height);
        int size = binaryTree.getSize();
        System.out.println("二叉树的结点数为：" + size);
        System.out.println("前序遍历");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("中序遍历");
        binaryTree.midOrder(binaryTree.root);
        System.out.println("后续遍历");
        binaryTree.postOrder(binaryTree.root);
    }
}
