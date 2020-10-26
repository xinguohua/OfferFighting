package com.todorex.offer17;

public class XinSolution {
    public int[] printNumbers(int n) {
        int max=0;
        int k=0;
        while(k!=n){
            max=max*10+9;
            k++;
        }
        int[] results=new int[max];
        for (int i = 0; i <max-1 ; i++) {
            results[i]=i+1;
        }
        results[max-1]=max;
        return results;
    }
}
