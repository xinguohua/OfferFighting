package com.todorex.week212;

import java.util.HashMap;

public class Solution5546 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        //扫描两个数组
        char[] chars = keysPressed.toCharArray();
        char result=chars[0];
        int MaxCharTime=0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int CharTme;

            if (i==0) {
                CharTme = releaseTimes[0];
            }else{
                CharTme=releaseTimes[i]-releaseTimes[i-1];
            }
            if (CharTme>MaxCharTime){
                    MaxCharTime = CharTme;
                    result = chars[i];

            }else if (CharTme==MaxCharTime&&chars[i]>result){
                MaxCharTime = CharTme;
                result = chars[i];
            }

        }

        return result;
    }


    public static void main(String[] args) {
        Solution5546 solution5546 = new Solution5546();
        int[] test =new int[]{12,23,36,46,62};
        char spuda = solution5546.slowestKey(test, "spuda");
        System.out.println(spuda);
    }
}
