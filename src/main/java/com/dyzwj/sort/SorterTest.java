package com.dyzwj.sort;


import java.util.Arrays;

public class SorterTest{

    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        int arr[] = new int[]{1,3,5,4,6,2,0};
        sorter.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}

class Sorter {


    //归并排序

    //冒泡排序

    //插入排序
    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) { // 0 - i范围内有序
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j -1]){
                    swap(arr,j-1,j);
                }else{
                    //只要j > j-1，那么j肯定大于j-2，j-3
                    break;
                }
            }
        }

    }

    //i和j是一个位置的话 会出错
    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
    }


    //选择排序



}
