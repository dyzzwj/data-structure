package com.dyzwj.tree;

/**
 * 判断一棵树是否是搜索二叉树
 *   若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树
 *
 */
public class IsBST {

    public static void main(String[] args) {

        System.out.println(isBST(init()));
    }

    static Integer max = Integer.MIN_VALUE;
    //搜索二叉树
    //搜索二叉树的每个子树 左中右节点应该是升序的 可以用中序遍历
    public static boolean isBST(Tree<Integer> tree){
        if(tree == null || tree.data == null){
            return true;
        }
        boolean bst = isBST(tree.left);
//        max = Math.max(tree.data,max);
        if(!bst || tree.data <= max){
            return false;
        }
        max = tree.data;
        return isBST(tree.right);

    }


    public static Tree init(){
        Tree root = new Tree(0);
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(8);
        Tree tree3 = new Tree(null);
        Tree tree4 = new Tree(null);
        Tree tree5 = new Tree(6);
        Tree tree6 = new Tree(9);
//        Tree tree7 = new Tree(8);


//        root.left = tree1;
//        root.right = tree2;
//        tree1.left = tree3;
//        tree1.right = tree4;
//        tree2.left = tree5;
//        tree2.right = tree6;
//        tree6.left = tree7;
        return root;
    }


}
