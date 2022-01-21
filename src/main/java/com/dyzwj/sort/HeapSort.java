package com.dyzwj.sort;


import java.util.Arrays;

/**
 * 堆排序
 *
 *  用数组表示满二叉树
 *   父节点：(i-1) / 2
 *   左孩子：(2i+1)
 *   右孩子：(2i+2)
 */
public class HeapSort {

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            Double num = 100 * Math.random();
            arr[i] = num.intValue();
        }

        heapSort.print(arr);

        for (int i = 0; i < arr.length; i++) {
            heapSort.heapInsert(arr,i);
        }

        heapSort.swap(arr,0,arr.length-1);

        for (int i = 0; i < arr.length-1; i++) {
            heapSort.heapify(arr,0,arr.length- i - 1);
            heapSort.swap(arr,0,arr.length-i-2);
        }

//        int size = arr.length;
//        heapSort.swap(arr,0,--size );
//        while (size > 0){
//            heapSort.heapify(arr,0,size);
//            heapSort.swap(arr,0,--size);
//        }



        heapSort.print(arr);
        System.out.println();

    }


    private void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "    ");
        }

        System.out.println();
    }

    //如何在输出堆顶元素后，调整剩余元素成为一个新的堆？

    /**
     * @param arr 待排序的数组
     * @param index 被下调节点的起始位置(一般为0，表示从第1个开始)
     * @param size 截至范围(一般为数组中最后一个元素的索引)
     */
    public void heapify(int[] arr, int index, int size) {

        for (; leftChild(index) < size; ) {
            int left = leftChild(index);

            //找到左右孩子较大的那个
            if(left < size - 1 && arr[left] < arr[left + 1]){
                left ++;
            }
            //父节点大于子节点较大的
            if(arr[index] > arr[left]){
                break;
            }
            swap(arr,index,left);
            //父节点等于较大的那个
            index = left;

        }



    }


    private int leftChild(int parent){
       return 2 * parent +1;
    }

    //如何由一个无序序列构建成一个堆？
    public void heapInsert(int[] arr,int i){
        //heapInsert就是构建堆的过程
        //孩子节点大于父节点
        while(arr[i] > arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i = (i-1) / 2;
        }
    }


    public void swap(int[] arr,int a,int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
