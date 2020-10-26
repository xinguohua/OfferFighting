package com.todorex.offer16;

public class XinSolution {
    public double myPow(double x, int n) {
        long N=n;//化成long，避免取正溢出
        if(N==0) return 1;
        if(x==1) return 1;
        if (N<0) {
            N = -N;
            x=1/x;
        }
        double result=1;
        while(N!=0){
            if(N%2==1){
                result=result*x;
            }
            N=N>>>1;
            x=x*x;
        }

        return result;
    }
}
