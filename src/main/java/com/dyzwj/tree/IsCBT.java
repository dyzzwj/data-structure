package com.dyzwj.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树
 *  若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 *      满足两个条件：
 *      1、无左节点 有右节点   不满足
 *      2、某个节点 有左节点 无右节点 则该节点后面的节点都必须是叶子结点
 */
public class IsCBT {

    public static void main(String[] args) {
        System.out.println(isCBT(TreeNode.init()));
    }


    //是否完全二叉树
    public static boolean isCBT(TreeNode treeNode){
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode right = poll.right;
            TreeNode left = poll.left;

            //无左节点 有右节点
            if(right != null && left == null){
                System.out.println("无左节点 有右节点:" + poll.data);
                return false;
            }
            //某个节点 有左节点 无右节点 则该节点后面的节点都必须是叶子结点
            if(flag && (left != null || right != null)){
                System.out.println("某个节点 有左节点 无右节点 则该节点后面的节点都必须是叶子结点:" + poll.data);
                return false;
            }

            if(poll.left != null){
                queue.add(left);
            }

            if(right != null){
                queue.add(right);
            }
            //某个节点 有左节点 无右节点
            if(left != null && right == null){
                flag = true;
            }
        }
        return true;
    }



}
