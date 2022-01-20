package com.dyzwj.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印ABC
 */


public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        Demo2 demo2 = new Demo2();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                demo2.methodA();
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                demo2.methodB();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                demo2.methodC();
            }
        });

        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        thread3.start();
        Thread.sleep(100);

    }

}

class Demo2{

    private Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();


    public void methodA(){

        lock.lock();
        try{
            System.out.println("A===" + Thread.currentThread().getName());
            b.signal();
            a.await();



        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void methodB(){
        lock.lock();
        try{
            System.out.println("B===" + Thread.currentThread().getName());
            c.signal();
            b.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void methodC(){
        lock.lock();
        try{
            System.out.println("c===" + Thread.currentThread().getName());
            a.signal();
            c.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
