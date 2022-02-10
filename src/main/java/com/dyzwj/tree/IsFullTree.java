package com.dyzwj.tree;


/**
 * 满二叉树：1、除最后一层无任何子节点外，每一层上的所有结点都有两个子结点的二叉树。
 *   每个子树的高度一样
 *
 *
 */
public class IsFullTree {

    public static void main(String[] args) {
        TreeNode init = TreeNode.init();
        System.out.println(isFull(init));
    }

    public static boolean isFull(TreeNode treeNode){
        return process(treeNode).isFull;
    }

    public static ReturnType process(TreeNode treeNode){
        if(treeNode == null){
            return new ReturnType(true,0);
        }
        ReturnType left = process(treeNode.left);
        ReturnType right = process(treeNode.right);
        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        int height = Math.max(left.height, right.height) + 1;
        return new ReturnType(isFull,height);
    }

    static class ReturnType{
        boolean isFull;
        int height;

        public ReturnType(boolean isFull, int height) {
            this.isFull = isFull;
            this.height = height;
        }
    }
}
