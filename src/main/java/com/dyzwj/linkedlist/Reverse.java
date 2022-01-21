package com.dyzwj.linkedlist;

/**
 * 单链表反转
 */

public class Reverse {

    public static void main(String[] args) {
        Entry entry1 = new Entry(1);
        Entry entry2 = new Entry(2);
        Entry entry3 = new Entry(3);
        Entry entry4 = new Entry(4);
        Entry entry5 = new Entry(5);
        Entry entry6 = new Entry(6);
        Entry entry7 = new Entry(7);
        Entry entry8 = new Entry(8);
        entry1.setNext(entry2);
        entry2.setNext(entry3);
        entry3.setNext(entry4);
        entry4.setNext(entry5);
        entry5.setNext(entry6);
        entry6.setNext(entry7);
        entry7.setNext(entry8);

        print(entry1);
        Entry reverse = reverse(entry1);
        print(reverse);

    }

    private static Entry reverse(Entry head){
        Entry cur = head;
        Entry prev = null;
        Entry next = null;
        while(cur != null ){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static void print(Entry entry){
        while (entry != null){
            System.out.print(entry.value + "   ");
            entry = entry.next;
        }

        System.out.println();

    }


}
class Entry{

    public Entry(int value) {
        this.value = value;
    }

    public Entry next;

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public int value;
}