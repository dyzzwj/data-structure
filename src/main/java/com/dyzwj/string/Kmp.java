package com.dyzwj.string;


import java.util.Arrays;

/**
 *   Kmp算法
 *   在一个文本串S中查找模式串P的位置，返回匹配成功后开始的下标
 */
public class Kmp {


    public static void main(String[] args) {
        String str = "abcabcd";
        System.out.println(Arrays.toString(getNext(str)));
    }

    public int kmp(String source,String target){
        //前缀后缀最长公共元素长度
        int[] next = getNext(target);


        return -1;
    }

    //前缀后缀最长公共元素长度
    private static int[] getNext(String target) {
        char[] chars = target.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int k = 0;//next[i-1]
        int i = 2;
        while (i < chars.length){
            if(chars[i - 1] == chars[k]){
                k++;
                next[i] = k;
                i++;
            }else if(k > 0){
                k = next[k];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }




    /**
     * 暴力匹配
     * @param source
     * @param target
     * @return
     */
    public int indexOf(String source,String target){
        if(source == null || target == null || source.length() < target.length()){
            return -1;
        }

        char[] sArr = source.toCharArray();
        char[] tArr = target.toCharArray();

        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()){
            //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
            if(sArr[i] == tArr[j] ){
                i++;
                j++;
            }else{
                //②如果不匹配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                i = i - j + 1;
                j = 0;
            }
        }

        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
        if(j == target.length()){
            return i - j;
        }else {
            return -1;
        }

    }


}
