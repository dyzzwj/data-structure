package com.dyzwj.linkedlist;


/**
 * 找链表的中点   快慢指针
 */
public class Test2 {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(findCentral(node1).data);
        System.out.println(findCentral1(node1).data);

    }

    public static Node findCentral(Node head){
        Node slow = head;
        Node fast = head;
        Node cur  = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static Node findCentral1(Node head){
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
