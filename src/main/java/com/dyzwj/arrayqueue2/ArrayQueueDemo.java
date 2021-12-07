package com.dyzwj.arrayqueue2;

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
        char key=' ';
        Scanner scan=new Scanner(System.in);
        boolean loop=true;
        while(loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("e(exit)：退出程序");
            key = scan.next().charAt(0);

            switch(key) {
                case's':
                    queue.showQueue();
                    break;
                case'a':
                    System.out.println("请输入一个数字：");
                    int value=scan.nextInt();
                    queue.addQueue(value);
                    break;
                case'g':
                    try {
                        int res=queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case'h':
                    try {
                        int res=queue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
                    scan.close();
                    loop=false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出~~");
    }

}

class ArrayQueue{
    private int size;//表示队列的最大容量
    private int[] arr;//存储数据
    private int front;//队列头
    private int rear;//队列尾

    public ArrayQueue(int size){
        this.size = size;
        this.arr = new int[size];
        this.front  = -1;
        this.rear = -1;
    }


    //是否满
    public boolean isFull(){
        return rear == size - 1;
    }

    //是否空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加元素
    public void addQueue(int data){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = data;

    }

    //取队首元素 出队
    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        front++;


        return arr[front];
    }

    //查看队首元素
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }



    //查看队列元素
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.println("arr[" + i + "]->" + arr[i]);
        }
    }


}

