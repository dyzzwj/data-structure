package com.dyzwj.tree;


import java.util.Stack;

/**
 *    树的遍历（非递归）
 */
public class Test2 {
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
        preOrder1(root);
        System.out.println();
        midOrder(root);

        System.out.println();
        midOrder1(root);

        System.out.println();
        postOrder(root);
    }



    //先序遍历 根左右
    public static void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
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
    public static void preOrder1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            //先把左边的根节点都压到栈中
            while (cur != null){
                System.out.print(cur.data + "    ");
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }
    }


    //中序遍历：左根右
    public static void midOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.data + "    ");
            cur = pop.right;
        }

    }



    public static void midOrder1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode pop = stack.pop();
                System.out.print(pop.data + "    ");
                cur = pop.right;
            }
        }

    }


    //后序遍历：左右根
    //两个栈
    public static void postOrder(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode pop = stack1.pop();
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
