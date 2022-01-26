package com.dyzwj.tree;

public class Tree<T> {

    T data;
    Tree<T> left;
    Tree<T> right;

    public Tree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }


    public static Tree init(){
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
        return root;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
