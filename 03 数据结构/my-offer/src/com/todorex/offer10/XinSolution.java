package com.todorex.offer10;

public class XinSolution {
    /**
     * 递归
     * 递归终止条件
     * 递进条件
     * 执行操作 是在递归
     * 递归方法超时
     * @param n
     * @return
     */
    public int fib(int n) {


        if (n==0 || n==1)
            return  n;


        return fib(n-1)+fib(n-2);
    }







    public static void main(String[] args) {
        System.out.println(new XinSolution().fib(3));
    }
}
