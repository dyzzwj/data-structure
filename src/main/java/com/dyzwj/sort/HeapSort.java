package com.dyzwj.sort;


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


    }

    //index：pop让第几个元素
    //arr已经是一个堆结构了
    public void heapify(int[] arr, int index, int size) {
        int parent = index;
        int left = 2 * parent +1;
        int right  = 2 * parent + 2;


    }

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
