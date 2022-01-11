package com.dyzwj.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        int [] a= {11,223,3,45,678,5,455,32,31,29};
        int nums=32;
        int x=-1;//标记小于区域,让后面小于的和小于区域的下一个位置交换，小于区域++
        //如果第一个位置是小于，其实就是和自己交换，i一定永远大于等于x
        for(int i=0;i<a.length;i++) {
            if(a[i]<=nums) {
                int temp=a[i];
                a[i]=a[x+1];
                a[x+1]=temp;
                x++;
            }
        }
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }

//        QuickSort quickSort = new QuickSort();
//        int[] arr = new int[20];
//        for (int i = 0; i < 20; i++) {
//            Double num = 100 * Math.random();
//            arr[i] = num.intValue();
//        }
//        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
//        System.out.println();
//        System.out.println(arr[9]);
//        quickSort.quick(arr,arr[9]);
//        Arrays.stream(arr).forEach(x -> System.out.print( x + " "));

    }

    //给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的 数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
    public void quick(int[] arr,int target){
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            //小于target的右边界
            if(arr[i] <= target){
                swap(arr,i,j+1);
                j++;
            }

        }
    }

    //i和j是一个位置的话 会出错
    private void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
