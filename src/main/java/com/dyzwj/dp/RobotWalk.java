package com.dyzwj.dp;


/**
 * 给你几个参数：
 * N：代表总共有多少个位置。
 * S：机器人的出发位置。
 * E：机器人的目的地。
 * K：机器人必须走K步。
 * 问题：请你求出机器人从起始位置S走K步到达终止位置E，一共有多少种走法？注意，每次机器人必须走一步，不能留在原地，每次只能走一格，可以向右或者向左。
 */
public class RobotWalk {

    public static void main(String[] args) {
        RobotWalk robotWalk = new RobotWalk();
        System.out.println(robotWalk.walk(5, 2, 4, 4));

    }

    public int walk(int N,int S,int E,int K){
        return process(N,E,S,K);
    }

    /**
     *
     * @param N
     * @param E 目的地
     * @param cur 当前来到的位置
     * @param rest 还能走rest步
     * @return
     */
    public int process(int N,int E,int cur,int rest){
        //如果剩余步数为0
        if(rest == 0){
            //当前是否走到了 目的地，如果走到了，则找到了一种走法，否则此种走法是错的
            return cur == E ? 1 : 0;
        }

        //来到了最左边的位置 只能向右走
        if(cur == 1){
            return process(N,E,cur + 1,rest -1);
        }

        //来到了最右边的位置 只能向左走
        if(cur == N){
            return process(N,E,cur - 1, rest -1);
        }

        //来到cur位置有多少种走法？ 能走rest-1步来到cur-1的位置的走法 + 能走rest-1步来到cur+1位置的走法
        return process(N,E,cur - 1,rest -1) + process(N,E,cur + 1,rest - 1);
    }

}
