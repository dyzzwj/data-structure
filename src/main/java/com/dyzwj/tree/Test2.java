package com.dyzwj.tree;


import java.util.Stack;

/**
 *    树的遍历（非递归）
 */
public class Test2 {
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
        preOrder1(root);
        System.out.println();
        midOrder(root);

        System.out.println();
        midOrder1(root);

        System.out.println();
        postOrder(root);
    }



    //先序遍历 根左右
    public static void preOrder(Tree root){
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Tree node = stack.pop();
            System.out.print(node.data + "    ");
            //左孩子先进栈  先进后出
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }

    }

    //先序遍历 根左右
    public static void preOrder1(Tree root){
        Stack<Tree> stack = new Stack<>();
        Tree cur = root;
        while(cur != null || !stack.isEmpty()){
            //先把左边的根节点都压到栈中
            while (cur != null){
                System.out.print(cur.data + "    ");
                stack.push(cur);
                cur = cur.left;
            }
            Tree pop = stack.pop();
            cur = pop.right;
        }
    }


    //中序遍历：左根右
    public static void midOrder(Tree root){
        Stack<Tree> stack = new Stack();
        Tree cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Tree pop = stack.pop();
            System.out.print(pop.data + "    ");
            cur = pop.right;
        }

    }



    public static void midOrder1(Tree root){
        Stack<Tree> stack = new Stack<>();
        Tree cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                Tree pop = stack.pop();
                System.out.print(pop.data + "    ");
                cur = pop.right;
            }
        }

    }


    //后序遍历：左右根
    //两个栈
    public static void postOrder(Tree root){
        Stack<Tree> stack1 = new Stack<>();
        Stack<Tree> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()){
            Tree pop = stack1.pop();
            stack2.push(pop);
            if(pop.left != null){
                stack1.push(pop.left);
            }
            if(pop.right != null){
                stack1.push(pop.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().data + "    ");
        }

    }
}
