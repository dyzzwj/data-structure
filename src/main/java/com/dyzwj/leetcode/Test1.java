package com.dyzwj.leetcode;


//三角形最小路径和

/**
 *       2
 *      3 4
 *     6 5 7
 *    4 1 8 3
 *
 *
 */

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int arr[][] = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        test1.minPath(arr);
    }

    //f[i][j] = min(f[i][j-1],f[i][j]) + c[i][j]
    public void minPath(int[][] arr){
        int dp[][] = new int[arr.length][arr[arr.length-1].length];
//        dp[0] = new int[]{arr[0][0]};
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            int[] ele = arr[i];

            for (int j = 0; j < ele.length; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][i-1] + arr[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr[arr.length-1].length; i++) {
            min = dp[dp.length-1][i] < min ? dp[dp.length-1][i] : min;
        }
        System.out.println(min);
    }
}
