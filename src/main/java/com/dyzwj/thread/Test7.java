package com.dyzwj.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *    线程1执行a和c方法 线程2执行b和d方法 要求执行顺序是 a -> b -> c -> d
 *
 *   a()        b()
 *
 *
 *   c()        d()
 *
 */

public class Test7 {

    public static void main(String[] args) throws InterruptedException {
        Demo7 demo7 = new Demo7();
        Thread thread1 = new Thread(() -> {
            demo7.methodA();
            demo7.methodC();
        });

        Thread thread2 = new Thread(() -> {
            demo7.methodB();
            demo7.methodD();
        });

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}

class Demo7{

    private ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();


    public void methodA(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " methodA");
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

     public void methodB(){

        lock.lock();
         try {
             System.out.println(Thread.currentThread().getName() + " methodB");
             condition1.signal();
             condition2.await();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
     }
     public void methodC(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " methodC");
            condition2.signal();
        }finally {
            lock.unlock();
        }

     }
     public void methodD(){
         System.out.println(Thread.currentThread().getName() + " methodD");
     }


}

