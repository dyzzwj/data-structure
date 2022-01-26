package com.dyzwj.linkedlist;


/**
 * 找链表的中点   快慢指针
 */
public class Test2 {


    public static void main(String[] args) {
        //头结点
//        Node head = new Node(null);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
//        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        System.out.println(findCentral(node1).data);
        System.out.println(findCentral1(node1).data);
        System.out.println(oddOrEven(node1));
    }

    public static Node findCentral(Node head){
        Node slow = head;
        Node fast = head;
        Node cur  = head;

        /**
         * 偶数个节点：
         *
         */
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 1、如果有奇数个节点
     *  fast.next != null满足  fast.next.next != null 不满足
     *  此时slow处于正中心的位置   1->2->3->4->5
     *  2、如果有偶数个节点 fast.next != null满足  fast.next.next != null 满足
     *  slow右移一个位置  此时slow为中心偏左的节点 1->2->3->4->5->6   slow指向3
     */
    public static Node findCentral1(Node head){
        Node slow = head;
        Node fast = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static boolean oddOrEven(Node head){
        Node fast = head;

        while(fast != null && fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
        }

        if(fast!= null && fast.next == null ){
            //奇数
            return false;
        }
        return true;
    }


}
