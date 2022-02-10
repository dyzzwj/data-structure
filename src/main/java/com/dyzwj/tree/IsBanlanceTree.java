package com.dyzwj.tree;


import sun.reflect.generics.tree.Tree;

/**
 *   平衡二叉树 ：
 *   （1）它是一棵空树或它的左右两个子树的高度差的绝对值不超过1；
 *
 *   （2）平衡二叉树的左右两个子树都是一棵平衡二叉树。
 */
public class IsBanlanceTree {


    public static void main(String[] args) {
        TreeNode init = TreeNode.init();
        System.out.println(isBT(init));
    }

    public static boolean isBT(TreeNode tree){
        return process(tree).isBT;
    }

    public static ReturnType process(TreeNode treeNode){
        if(treeNode == null){
            return new ReturnType(true,0);
        }
        ReturnType left = process(treeNode.left);
        ReturnType right = process(treeNode.right);
        //当前子树的高度
        int heigth = Math.max(left.height,right.height) + 1;
        //当前子树是否是平衡二叉树
        boolean isBT = left.isBT && right.isBT && (Math.abs(left.height - right.height) < 2);
        return new ReturnType(isBT,heigth);

    }

    static class ReturnType{
        boolean isBT;
        int height;

        public ReturnType(boolean isBT, int height) {
            this.isBT = isBT;
            this.height = height;
        }
    }


}
