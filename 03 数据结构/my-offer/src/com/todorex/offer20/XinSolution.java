package com.todorex.offer20;

public class XinSolution {
    public int[] exchange(int[] nums) {
        int[] temp =new int[nums.length];
        int first=0;
        int last=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&1)==1){
                temp[first++]=nums[i];
            }else{
                temp[last--]=nums[i];
            }
        }


        return temp;

    }
}
