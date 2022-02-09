package com.dyzwj.tree;


/**
 * 树的遍历（递归）
 *  先序遍历  根左右
 *  中序遍历  左根右
 *  后序遍历  左右根
 *   递归实现：递归序
 *
 *
 */
public class Test1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);


        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode6.left = treeNode7;
        preOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        postOrder(root);
    }

    //根左右
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + "    ");
        preOrder(root.left);

        preOrder(root.right);
    }

    //左根右
    public static void midOrder(TreeNode root){
        if(root == null){
            return;
        }

        midOrder(root.left);
        System.out.print(root.data + "    ");
        midOrder(root.right);

    }

    //左右根
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "    ");

    }

}
