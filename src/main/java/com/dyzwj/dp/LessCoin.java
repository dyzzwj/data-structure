package com.dyzwj.dp;


/**
 * 假设有 1 元，3 元，5 元的硬币若干（无限），现在需要凑出 11 元，问如何组合才能使硬币的数量最少？
 */
public class LessCoin {

    public int lesscoin(int[] coins,int target){
        return process(coins,0,target);
    }

    /**
     *    [index...]index后的硬币要凑够rest
     * @param coins 硬币量
     * @param index 现在能选择的硬币 是index后的硬币
     * @param rest  0....index硬币已经凑出了target - rest
     * @return
     */
    public int process(int[] coins,int index,int rest){

        return 0;
    }

}
