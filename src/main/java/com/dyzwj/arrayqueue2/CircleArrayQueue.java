package com.dyzwj.arrayqueue2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray queue=new CircleArray(3);
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


class CircleArray{

    private int size;//队列容量
    private int[] arr;//存储数据
    private int front;//指向队列的第一个元素
    private int rear;//指向队列最后一个元素的后一个元素（相当于队列的容量只有size -1）  如果不预留一个元素 不太好判断队列空和队列满

    public CircleArray(int size){
        this.size = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    //队列满
    public boolean isFull(){
        return (rear - front + 1 ) % arr.length == 0 ;
    }

    //队列空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加元素
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear % arr.length] = num;
        rear ++;
    }

    //取出队首 出队
    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        int temp = arr[front % arr.length];
        front ++;
        return temp;
    }

    //查看队首
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front % arr.length];
    }
    //查看队列元素
    public void showQueue(){
        for (int i = front ; i < front + (rear - front) % arr.length;i++){
            System.out.println(arr[i % arr.length]);
        }
    }
}