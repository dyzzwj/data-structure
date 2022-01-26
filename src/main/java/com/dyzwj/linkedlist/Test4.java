package com.dyzwj.linkedlist;


import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 *
 *
 */
public class Test4 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
//        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node<Integer> slow = node1;
        Node fast = node1;
        //是否奇数个节点
        boolean odd = false;
        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            //奇数个
            odd = true;
        }
        if(odd){
            slow = slow.next;
        }

        while(slow !=  null ){
            if(slow.data != stack.pop()){
                System.out.println(false);
                return;
            }
            slow = slow.next;

        }
        System.out.println(true);

    }

}
