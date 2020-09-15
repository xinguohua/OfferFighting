package com.todorex.dataStructure.section1;

//秦九韶多项式方法
public class f2 implements MethodInterface {
    @Override
    public double f(int n, double[] a, double x) {
        double p=a[n];
        for (int i =n ; i >0 ; i--) {
            p=p*x+a[i-1];
        }
        return p;
    }
}
