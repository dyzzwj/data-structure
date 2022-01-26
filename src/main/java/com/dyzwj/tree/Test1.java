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
        Tree root = new Tree(1);
        Tree tree1 = new Tree(2);
        Tree tree2 = new Tree(3);
        Tree tree3 = new Tree(4);
        Tree tree4 = new Tree(5);
        Tree tree5 = new Tree(6);
        Tree tree6 = new Tree(7);
        Tree tree7 = new Tree(8);


        root.left = tree1;
        root.right = tree2;
        tree1.left = tree3;
        tree1.right = tree4;
        tree2.left = tree5;
        tree2.right = tree6;
        tree6.left = tree7;
        preOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        postOrder(root);
    }

    //根左右
    public static void preOrder(Tree root){
        if(root == null){
            return;
        }
        System.out.print(root.data + "    ");
        preOrder(root.left);

        preOrder(root.right);
    }

    //左根右
    public static void midOrder(Tree root){
        if(root == null){
            return;
        }

        midOrder(root.left);
        System.out.print(root.data + "    ");
        midOrder(root.right);

    }

    //左右根
    public static void postOrder(Tree root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "    ");

    }

}
