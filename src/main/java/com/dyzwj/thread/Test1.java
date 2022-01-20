package com.dyzwj.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印1-100
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Demo1 demo1 = new Demo1(100);
        Thread thread1 = new Thread(() -> {
            demo1.method1();
        });

        Thread thread2 = new Thread(() -> {
            demo1.method2();
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();




    }

}

class Demo1{

    private Integer num = 0;
    private Integer max;
    private ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public Demo1(Integer max) {
        this.max = max;
    }

    public void method1(){
        //加锁
        lock.lock();
        try{
            for (; num <= max ; ) {
                System.out.println(num ++ + "=====" +Thread.currentThread().getName());
                condition1.await();
                condition2.signal();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void method2(){
        //加锁
        lock.lock();
        try{
            for (; num <= max ; ) {
                System.out.println(num++  + "=====" +Thread.currentThread().getName());
                condition1.signal();
                condition2.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    private static Object lock1 = new Object();
    private static int i = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (; i <= 100;) {
                synchronized (lock1) {
                    System.out.println(i ++ + "：我是偶数");
                    try {
                        lock1.notify();
                        if (i <= 100) {
                            lock1.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (; i <= 100;) {
                synchronized (lock1) {
                    System.out.println(i ++ + "：我是奇数");
                    try {
                        if (i <= 100) {
                            lock1.wait();
                        }
                        lock1.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        t2.start();
        t1.start();

    }




}



