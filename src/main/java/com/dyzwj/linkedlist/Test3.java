package com.dyzwj.linkedlist;


/**
 * 打印两个有序链表的公共部分
 */
public class Test3 {

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


        Node node11 = new Node(1);
        node11.next = node5;
        Node<Integer> cur1 = node1;
        Node<Integer> cur2 = node11;


        while (cur1 != null && cur2 != null){
            if(cur1.data > cur2.data){
                cur2 = cur2.next;
            }else if(cur1.data < cur2.data){
                cur1 = cur1.next;
            }else{
                //值相等 判断是不是同一个节点
                if(cur1 == cur2){
                    break;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }

        while (cur1 != null){
            System.out.println(cur1.data);
            cur1 = cur1.next;
        }

    }

}
