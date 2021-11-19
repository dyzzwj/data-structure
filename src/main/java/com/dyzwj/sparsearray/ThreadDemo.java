package com.dyzwj.sparsearray;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {


    public static void a(){
        System.out.println(Thread.currentThread().getName() + ":a");
    }

    public static void b(){
        System.out.println(Thread.currentThread().getName() + ":b");
    }

    public static void c(){
        System.out.println(Thread.currentThread().getName() + ":c");
    }
    public static void d(){
        System.out.println(Thread.currentThread().getName() + ":d");
    }


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();


        //线程1
        new Thread(() -> {
            lock.lock();

            a();
            try {

                condition1.await();
                c();
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程2
        new Thread(() -> {
            lock.lock();
            try {

                b();
                condition1.signal();
                condition2.await();;
                d();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }).start();
    }



}
