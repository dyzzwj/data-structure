package com.dyzwj.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(new Hero(1,"宋江","及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2,"林冲","豹子头"));
        HeroNode heroNode3 = new HeroNode(new Hero(3,"吴用","智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4,"卢俊义","玉麒麟"));
        HeroNode heroNode5 = new HeroNode(new Hero(5,"曹操","曹阿瞒"));
        HeroNode heroNode6 = new HeroNode(new Hero(6,"刘备","liubei"));
        HeroNode heroNode7 = new HeroNode(new Hero(7,"诸葛亮","孔明"));
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode5);
        singleLinkedList.add(heroNode6);
        singleLinkedList.add(heroNode7);

//        System.out.println(singleLinkedList.findLastK(5).getData());
        HeroNode reverse = singleLinkedList.reverse(singleLinkedList.head);
        singleLinkedList.show(reverse);
    }





}


//带头结点的链表
class SingleLinkedList{

    //头结点
    HeroNode head = new HeroNode(null);

    //添加节点

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //打印链表的数据
    public void show(){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println(temp.getData());
        }

    }

    //打印链表的数据
    public void show(HeroNode head){
        HeroNode temp = head;
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
    public HeroNode merge(HeroNode heroNode1, HeroNode heroNode2){
        HeroNode heroNode = new HeroNode(null);
        while (heroNode1.next != null && heroNode2.next != null){

        }
        return heroNode;
    }

    //单链表反转
    public HeroNode reverse(HeroNode head){

        HeroNode prev = null;
        HeroNode curr = head;
        while(curr != null){
            HeroNode temp = curr.next;
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
    public HeroNode findLastK(int k){
        if(k < 0){
            throw new RuntimeException("非法的参数");
        }
        HeroNode first = head;
        HeroNode second = head;
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
class HeroNode {
    public Hero data;
    public HeroNode next;

    public HeroNode(Hero hero){
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