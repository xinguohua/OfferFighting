package com.todorex.week210;

import com.todorex.offer40.Solution;

import java.util.LinkedList;
//(1)+((2))+(((3)))
public class Solution5335 {
    public int maxDepth(String s) {
        int maxcount=0;
        int count=0;
        LinkedList<Character> stack =new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]=='('){
                stack.push('(');
                count++;
            }
            if(chars[i]==')'){
                if (!stack.isEmpty()){
                    stack.pop();
                    if (count>maxcount){
                        maxcount=count;

                    }
                    count=stack.size();
                }

            }
        }


        return maxcount;
    }


    public static void main(String[] args) {
        int i = new Solution5335().maxDepth("(1)+((2))+(((3)))");
        System.out.println(i);
    }
}
