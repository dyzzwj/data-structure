package com.dyzwj.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  交替打印字母abcd和数字1234
 *  两个线程，打印结果为：a1b2c3d4
 *  线程1负责输出abcd
 *  线程2负责输出1234
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        Demo3 demo3 = new Demo3();

        Thread thread1 = new Thread(() -> {
            demo3.method1();
        });

        Thread thread2 = new Thread(() -> {
            demo3.method2();
        });

        thread1.start();
        Thread.sleep(100);

        thread2.start();
    }

}

class Demo3{

    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    int[] num = new int[]{1,2,3,4};
    char[] ch = new char[]{'a','b','c','d'};

    //输出abcd
    public void method1(){
        for (int i = 0; i < num.length; i++) {
            lock.lock();
            try{
                System.out.print(num[i]);
                condition2.signal();
                condition1.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }

    //输出1234
    public void method2(){
        for (int i = 0; i < ch.length; i++) {
            lock.lock();
            try{
                System.out.print(ch[i]);
                condition1.signal();
                condition2.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }


}
