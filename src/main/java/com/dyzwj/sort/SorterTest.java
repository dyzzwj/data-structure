package com.dyzwj.sort;


import java.util.Arrays;

public class SorterTest{

    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        int arr[] = new int[]{1,3,5,4,6,2,0};
        sorter.guibing(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}

class Sorter {



    //归并排序
    public void guibing(int[] arr){
        process(arr,0,arr.length-1);
    }

    public void process(int[] arr,int start,int end){
        if(start == end){
            return ;
        }
        int middle = start + (end -start ) /2;
        process(arr,start,middle);
        process(arr,middle + 1,end);
        merge(arr,start,middle,end);
    }

    private void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[ end - start + 1];
        int j = middle + 1;
        int i = start;
        int index = 0;
        while (i <= middle && j <= end){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i++;
            }else{
                temp[index] = arr[j];
                j++;
            }
            index++;
//            temp [index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= middle){
            temp[index++] = arr[i++];
        }
        while (j <= end) {
            temp[index++] = arr[j++];
        }
        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[start++] = temp[i1];
        }
    }


    //冒泡排序
    public void bubble(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }


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

    //异或的方式 i和j是一个位置的话 会出错
    private void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //选择排序
    public void choose(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //每轮找剩余未排序的最大值对应的下标
            int max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                max = arr[j] > arr[max] ? j : max;
            }
            swap(arr,max,arr.length - i -1);
        }

    }







}
