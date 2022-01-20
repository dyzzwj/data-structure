package com.dyzwj.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个窗口同时卖票
 */
public class Test4 {

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4(200);
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                demo4.sale();
        }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                demo4.sale();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                demo4.sale();
            }
        }).start();
    }

}

class Demo4{

    private int ticket;
    private Lock lock = new ReentrantLock();

    public Demo4(int ticket) {
        this.ticket = ticket;
    }

    public void sale(){
        lock.lock();
        try{

            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖的第" + ticket-- +  "张票");
            }else {
                System.out.println("票卖完了");
            }
        }finally {
            lock.unlock();
        }

    }



}



