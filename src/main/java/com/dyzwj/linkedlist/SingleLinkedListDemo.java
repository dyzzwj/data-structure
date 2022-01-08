package com.dyzwj.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(new Hero(1,"宋江","及时雨"));
        Node node2 = new Node(new Hero(2,"林冲","豹子头"));
        Node node3 = new Node(new Hero(3,"吴用","智多星"));
        Node node4 = new Node(new Hero(4,"卢俊义","玉麒麟"));
        Node node5 = new Node(new Hero(5,"曹操","曹阿瞒"));
        Node node6 = new Node(new Hero(6,"刘备","liubei"));
        Node node7 = new Node(new Hero(7,"诸葛亮","孔明"));
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.add(node5);
        singleLinkedList.add(node6);
        singleLinkedList.add(node7);

//        System.out.println(singleLinkedList.findLastK(5).getData());
        Node reverse = singleLinkedList.reverse(singleLinkedList.head);
        singleLinkedList.show(reverse);
    }





}


//带头结点的链表
class SingleLinkedList{

    //头结点
    Node head = new Node(null);

    //添加节点

    public void add(Node node){
        Node temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //打印链表的数据
    public void show(){
        Node temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println(temp.getData());
        }

    }

    //打印链表的数据
    public void show(Node head){
        Node temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println(temp.getData());
        }

    }

    //添加的节点是有序的

    //合并两个有序链表  新建节点
    public Node merge(Node node1,Node node2){
        Node node = new Node(null);
        while (node1.next != null && node2.next != null){

        }
        return node;
    }

    //单链表反转
    public Node reverse(Node head){

        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
        //当前节点
//        Node cur = head;
        //当前节点的下一个节点
//        Node prev = head.next;
//        head.next = null;
//        while(prev != null && prev.next != null){
//            Node temp = prev.next;
//            prev.next = cur;
//            cur = prev;
//            prev = temp;
//            if(prev.next == null){
//                prev.next = cur;
//                break;
//            }
//        }
//        return prev;
    }


    //查找单链表中的倒数第k个节点
    public Node findLastK(int k){
        if(k < 0){
            throw new RuntimeException("非法的参数");
        }
        Node first = head;
        Node second = head;
        //k = 0 时才会退出循环
        //倒数第k个节点 从0开始计数
        while(k > 0){
            if(first.next == null){
                throw new RuntimeException("不存在倒数第" + k + "个节点");
            }
            first = first.next;
            k --;
        }
        while (true){
            if(first.next == null){
                break;
            }
            first = first.next;
            second = second.next;
        }

        return second;
    }
}


@Data
class Node{
    public Hero data;
    public Node next;

    public Node(Hero hero){
        this.data = hero;
    }


}

@AllArgsConstructor
@ToString
@Data
class Hero{
    private Integer order;
    private String name;
    private String nickname;
}