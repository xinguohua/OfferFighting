package com.todorex.dataStructure.section1;

import static java.lang.Math.pow;

//朴素多项式方法
public class f1 implements MethodInterface{
    @Override
    public double f(int n, double[] a, double x) {
        int p=0;
        for (int i = 0; i <=n ; i++) {
            p+=(a[i]*pow(x,i));
        }
        return p;
    }
}
