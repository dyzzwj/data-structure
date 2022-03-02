package com.dyzwj.dp;


/**
 *
 *  递归（尝试方法）
 *
 *  记忆化搜索（缓存）
 *
 *  严格表依赖
 *      1、分析可变参数的变化范围 (n个可变参数 -> n维表)
 *      2、标出计算的终止位置
 *      3、标出不用计算，直接出答案的位置(base case)  范围上尝试的时候先填对角线
 *      4、看依赖 普遍的位置是如何依赖其他位置的
 *      5、确定依次计算的顺序
 *
 */


/**
 *
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
     * @param rest  0....index硬币已经凑出了target - rest   index后的硬币还需要凑rest
     * @return
     */
    public int process(int[] coins,int index,int rest){

        return 0;
    }

}
