package com.dyzwj.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *  [3,9,20,15,7]
 */
public class Test3 {

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
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.data + "    ");
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }


    }


}
