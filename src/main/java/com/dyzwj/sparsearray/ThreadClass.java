package com.dyzwj.sparsearray;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadClass {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass();

        new Thread(() -> {
            threadClass.a();
            threadClass.c();
        }).start();

        new Thread(() -> {
            threadClass.b();
            threadClass.d();
        }).start();


    }

    public void a(){
        lock.lock();
        try{
            System.out.println("a");
            condition1.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void b(){
        lock.lock();
        try{
            System.out.println("b");
            condition1.signal();
            condition2.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void c(){
        lock.lock();
        try{
            System.out.println("c");
            condition2.signal();
            condition1.await();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void d(){
        lock.lock();;
        try{
            System.out.println("d");
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }



}
