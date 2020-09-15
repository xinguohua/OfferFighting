package com.todorex.offer3;

import java.util.*;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        //考虑扩容浪费时间
        HashMap<Integer,Integer> hashMap= new HashMap<>(nums.length);
        for (int num : nums) {
            if (hashMap.containsKey(num)){
                return num;
            }else{
                hashMap.put(num,0);
            }

        }
        return -1;
    }
}
