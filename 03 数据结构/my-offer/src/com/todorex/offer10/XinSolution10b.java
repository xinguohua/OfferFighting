package com.todorex.offer10;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
//        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

import java.util.HashMap;

public class XinSolution10b {

    HashMap<Integer,Integer> hm = new HashMap<>();
    public int numWays(int n) {
        hm.put(0,1);
        hm.put(1,1);

        if (n==0 || n==1)
            return 1;

        //有两种方案 n-2  n-1
        if (hm.containsKey(n))
            return hm.get(n);
        int result=numWays(n-2)+numWays(n-1);
        hm.put(n,result% 1000000007);
        return result% 1000000007;

    }



    public static void main(String[] args) {
        System.out.println(new XinSolution10b().numWays(7));
    }
}
