package com.dyzwj.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树的宽度优先遍历 求二叉树的宽度
 */
public class TreeMaxWidth {

    public static void main(String[] args) {
        System.out.println(width(TreeNode.init()));
    }

    //求二叉树的宽度
    public static int width(TreeNode treeNode){
        int currentLevel = 1;
        Map<TreeNode,Integer> map = new HashMap<>();
        int maxWidth = Integer.MIN_VALUE;
        int currentWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        map.put(treeNode,currentLevel);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();

            if(poll.left != null){
                map.put(poll.left,map.get(poll) + 1);
                queue.add(poll.left);
            }
            if(poll.right != null){
                map.put(poll.right,map.get(poll) + 1);
                queue.add(poll.right);
            }
            if(map.get(poll) > currentLevel){
                currentWidth = 1;
                currentLevel = map.get(poll);
            }else{
                currentWidth ++;
            }
            maxWidth = Math.max(currentWidth,maxWidth);
        }

        return maxWidth;

    }


}
