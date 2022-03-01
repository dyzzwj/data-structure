package com.dyzwj.bit;

import java.util.Arrays;


/**
 * 位运算 之异或
 *
 *  1、交换律
 *
 * 2、结合律（即(a^b)^c == a^(b^c)）
 *
 * 3、对于任何数x，都有x^x=0，x^0=x
 *
 * 4、自反性:  a^b^b=a^0=a;
 *
 */
public class OddEvenTimesNumber {



    public static void main(String[] args) {
        System.out.println(odd(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));
        System.out.println(Arrays.toString(even(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 6, 5})));
    }


    //一个数组 只有一种数出现了奇数次，其他数出现了偶数次
    public static int odd(int[] arr){
        int a = 0;
        for (int j = 0; j < arr.length; j++) {
            a ^= arr[j];
        }
        return a;
    }

    //一个数组 只有两种数（x、y）出现了奇数次，其他数出现了偶数次
    public static int[] even(int[] arr){
        int a = 0;
        //先获取x ^ y 的结果
        for (int j = 0; j < arr.length; j++) {
            a ^= arr[j];
        }

        //获取i表示整数二进制最右边的1
        int num = mostRight1(a);
        int x = 0;
        int y = 0;
        for (int j = 0; j < arr.length; j++) {
            if((num & arr[j]) == 0){
                x ^= arr[j];
            }else {
                y ^= arr[j];
            }

        }

        return new int[]{x,y};
    }

    /**
     * 取整数二进制表示中最右边的1   n & (-n)  等价于 n & ~(n - 1)
     * @param number
     * @return
     */
    private static int mostRight1(int number){
        return number & (-number);
    }

}
