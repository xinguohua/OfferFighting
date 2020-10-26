package com.todorex.offer15;

import java.util.HashMap;

public class XinSolution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

            int count=0;
            while(n!=0){
                count= count+(n&1);

                n=n>>>1;
            }
            return count;
    }


    public static void main(String[] args) {
        int i = new XinSolution().hammingWeight(0b11111111111111111111111111111101);
        System.out.println(i);
        System.out.println(0b11111111111111111111111111111101&0b01);
    }
}
