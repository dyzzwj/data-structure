package com.dyzwj.arrayqueue2;

public class CircleArrayQueue {
}


class CircleArray{

    private int size;//队列容量
    private int[] arr;//存储数据
    private int front;//指向队列的第一个元素
    private int rear;//指向队列的后一个元素的后一个位置

    public CircleArray(int size){
        this.size = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    //队列满
    public boolean isFull(){

    }

    //队列空
    public boolean isEmpty(){

    }
    //添加元素

    //取出队首 出队

    //查看队首

    //查看队列元素

}