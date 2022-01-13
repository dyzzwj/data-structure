package com.dyzwj.sort;


import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放 在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度O(1)，时间复杂度 O(N)
 */
public class HelanFlag {

    public static void main(String[] args) {
        HelanFlag helanFlag = new HelanFlag();

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            Double num = 100 * Math.random();
            arr[i] = num.intValue();
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(arr[9]);
        helanFlag.flag(arr,arr[9]);
        Arrays.stream(arr).forEach(x -> System.out.print( x + " "));

    }

    //给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放 在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度O(1)，时间复杂度 O(N)
    public void flag(int[] arr,int target){
        //小于target的右边界
        int i = -1;
        //大于target的左边界
        int j = arr.length;
        //数组指针
        int k = 0;
        while(k < j){
            int cur = arr[k];
            if(cur > target){
                swap(arr,k,--j);
            }else if(cur == target){
                k++;
            }else if(cur < target){
                swap(arr,++i,k++);
            }
            //arr[k] > target arr[k]和arr[j-1]交换 i不变 k不变 j--
            //arr[k] = target k自增
            //arr[k] < target arr[k] 和 i+1交换 i++ k++
        }
    }

    public void swap(int[] arr,int a,int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
