package com.dyzwj.leetcode;


/**
 * 岛问题
 *
 * 一个矩阵中只有0和1两种值 每个位置都可以和自己的上下左右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求这个矩阵中有多少个岛
 *
 *  输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 *
 * 输出：3
 *
 */
public abstract class Island {


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        System.out.println(island(arr));

    }


    public static int island(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){

            for (int j = 0;j < arr[i].length;j++){
                if(arr[i][j] == 1){
                    sum++;
                    infect(arr,i,j,arr.length,arr[i].length);
                }
            }
        }

        return sum;
    }

    public static void infect(int[][] arr,int i,int j,int m,int n){
        if(i >= m || j >= n | i < 0 || j <0 || arr[i][j] != 1){
            return;
        }
        arr[i][j] = 2;
        //上
        infect(arr,i-1,j,m,n);
        //下
        infect(arr,i + 1,j,m,n);
        //左
        infect(arr,i,j-1,m,n);
        //右
        infect(arr,i,j+1,m,n);

    }

}
