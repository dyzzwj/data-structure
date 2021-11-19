package com.dyzwj.sparsearray;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 {

    public static void main(String[] args) {
        ReentrantLock rLock = new ReentrantLock();
        Condition condition = rLock.newCondition();
        Condition condition1 = rLock.newCondition();

        new Thread(()->{
            char a = 'A';
            try {
                for(int i=0;i<26;i++){
                    rLock.lock();
                    System.out.println(a);
                    Thread.sleep(1000);
                    a++;
                    condition1.signal();
                    condition.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                rLock.tryLock();
            }
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            try {
                for(int i=1;i<27;i++){
                    rLock.lock();
                    System.out.println(i);
                    Thread.sleep(1000);
                    condition.signal();
                    condition1.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                rLock.tryLock();
            }
        }).start();

    }

}
