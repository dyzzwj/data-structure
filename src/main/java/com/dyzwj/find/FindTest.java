package com.dyzwj.find;


class Find{


    //有序数组中某个数是否存在
    //二分查找
    public int sort1(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while(end >= start){
            int middle = start + (end - start) / 2;
            if(target > arr[middle]){
                start = middle + 1;
            }else if(target < arr[middle]){
                end = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }


    public int test3(int[] arr,int target){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] >= target){
                return i;
            }

        }
        return -1;
    }

    //有序数组中找大于某个数最左侧的位置
    public int test2(int[] arr,int target){
        int start = 0;
        int end = arr.length;
        while(end > start){
            int middle = start + (end - start) / 2;
            if(arr[middle] > target){
                end = middle;
            }else if(arr[middle] < target){
                start = middle + 1;
            }else if(arr[middle] == target){
                end = middle;
            }
        }

        return start;

    }




    //局部最小值 数组 任意相邻的数不相等




}
