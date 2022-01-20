package com.dyzwj.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 10个线程计算1~100的和
 *  编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
 *
 *  1、CountDownLatch
 *  2、Thread.join :让父线程等待子线程结束之后才能继续运行。
 *
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            final int j = i + 1;
            //10个线程
            new Thread(() -> {
                arr[j-1] = cacu(j);
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        System.out.println(sum);

    }

    private static int cacu(int i){
        int sum  = 0;
        int begin = 1 + (i -1) * 10;
        for (int j = begin; j <= i * 10; j++) {
            sum+= j;
        }
        return sum;
    }


}
