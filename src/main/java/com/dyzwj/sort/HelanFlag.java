package com.dyzwj.sort;


/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放 在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度O(1)，时间复杂度 O(N)
 */
public class HelanFlag {

    public static void main(String[] args) {

    }

    //给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放 在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度O(1)，时间复杂度 O(N)
    public void flag(int[] arr,int target){
        //小于target的右边界
        int i = -1;
        //大于target的左边界
        int j = arr.length;

        while(j > i){
            //arr[k] > target arr[k]和arr[j-1]交换 i不变 k不变
            //arr[k] = target k自增
            //arr[k] < target arr[k] 和 i+1交换
        }


    }


}
