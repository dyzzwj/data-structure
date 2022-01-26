package com.dyzwj.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树的宽度优先遍历 求二叉树的宽度
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(width(Tree.init()));
    }

    //求二叉树的宽度
    public static int width(Tree tree){
        int currentLevel = 1;
        Map<Tree,Integer> map = new HashMap<>();
        int maxWidth = Integer.MIN_VALUE;
        int currentWidth = 0;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        map.put(tree,currentLevel);
        while (!queue.isEmpty()){
            Tree poll = queue.poll();

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
