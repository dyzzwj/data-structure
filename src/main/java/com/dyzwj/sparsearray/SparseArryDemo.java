package com.dyzwj.sparsearray;


import com.sun.scenario.effect.impl.state.AccessHelper;

import java.util.Arrays;

/**
 * 稀疏数组
 */
public class SparseArryDemo {

    private static void print(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    };

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        print(arr);
        int[][] sparse = chessToSparse(arr);
        //数组转稀疏数组
        print(sparse);

        //稀疏数组转二维数组
        int[][] chessArr = sparseToChess(sparse);
        print(chessArr);
    }


    //二维数组转稀疏数组
    public static int[][] chessToSparse(int[][] chessArr){
        //有效数据
        int efficient = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if(anInt != 0){
                    efficient ++;
                }
            }
        }
        int[][] sparseArray = new int[efficient + 1][3];
        int i = 0;
        int size = 0;
        int cursor = 0;
        for (; i < chessArr.length; i++) {
            int[] ele = chessArr[i];
            int j = 0;
            for (; j < ele.length; j++) {
                if(chessArr[i][j] != 0){
                    cursor ++;
                    sparseArray[cursor][0] = i;
                    sparseArray[cursor][1] = j;
                    sparseArray[cursor][2] = chessArr[i][j];
                }
            }
            size = j;

        }
        sparseArray[0][0] = i;
        sparseArray[0][1] = size;
        sparseArray[0][2] = efficient;
        return sparseArray;
    }



    public static int[][] sparseToChess(int[][] sparseArr){
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            int[] meta = sparseArr[i];
            chessArr[meta[0]][meta[1]] = meta[2];
        }
        return chessArr;
    }

}



