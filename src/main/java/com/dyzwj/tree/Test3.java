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
        //队列
        Queue<Tree> queue = new LinkedList<>();
        Tree cur = root;
        queue.add(root);
        while (!queue.isEmpty()){
            Tree poll = queue.poll();
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
