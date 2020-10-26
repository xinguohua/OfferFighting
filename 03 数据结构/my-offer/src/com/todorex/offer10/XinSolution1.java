package com.todorex.offer10;

import java.util.HashMap;

//动态规划  递归+缓存（记忆化）
public class XinSolution1 {

    HashMap<Integer,Integer> hm =new HashMap<>();


    public int fib(int n) {

        if (n==0 || n==1)
            return  n;

        hm.put(0,0);
        hm.put(1,1);

        if(hm.containsKey(n))
            return hm.get(n);



        int a=fib(n-1);
        int b=fib(n-2);
        hm.put(n-1,a);
        hm.put(n-2,b);
        int res=a+b;
        return res% 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(new XinSolution().fib(45));
    }


}
