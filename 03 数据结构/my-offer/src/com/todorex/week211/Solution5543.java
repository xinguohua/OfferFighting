package com.todorex.week211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//mgntdygtxrvxjnwksqhxuxtrv
public class Solution5543 {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        int maxlength=-1;
        for (int i = 0; i < chars.length; i++) {
            if (!hm.containsKey(chars[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(chars[i],list);
            }else {
                //¸üÐÂmaxlength
                ArrayList<Integer> list = hm.get(chars[i]);
                list.add(i);
                int length=i-list.get(0)-1;
                if (length>maxlength){
                    maxlength=length;
                }
            }
        }

        return maxlength;
    }
}
