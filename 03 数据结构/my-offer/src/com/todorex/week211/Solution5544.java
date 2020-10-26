package com.todorex.week211;

import com.todorex.week210.Solution5335;

import java.util.HashSet;

public class Solution5544 {

    String min;
    public String findLexSmallestString(String s, int a, int b) {
        char[] chars = s.toCharArray();
        HashSet<char[]> hashSet= new HashSet<>();
        min=s;
        char[] result=findMinString(chars,hashSet,a,b);
        String ans =new String(result);
        return ans;

    }

    public char[] findMinString(char[] chars,HashSet<char[]> hashSet,int a, int b) {
        if (hashSet.contains(chars)) {
            return chars;
        }else{
            hashSet.add(chars);
        }

        for (int i = 0; i <2 ; i++) {
            if (i==0){
                add(chars,a);
            }else{
                chars=transfer(chars,b);
            }
            char[] minString = findMinString(chars, hashSet, a, b);
            String s1=new String(minString);
            if (min.compareTo(s1)>0){
                min=s1;
            }
        }



        return chars;
    }


    public void add(char[] chars,int a){
        for (int i = 0; i < chars.length; i++) {
            if (i%2==1){
                int num=(int)chars[i]+a;
                if (num>9){
                    chars[i]=(char) (chars[i]-'9'-1);
                }
            }
        }}

    public char[] transfer(char[] chars,int b){
        char[] newchars=new char[chars.length];
        for (int i = 0; i < b; i++) {
            newchars[i]=chars[chars.length-b+i];
        }
        int index=0;
        for (int i =b; i < chars.length-1; i++){
            newchars[i]=chars[index++];
        }
        chars=newchars;

        return chars;

    }

    public static void main(String[] args) {
        Solution5544 solution5544 = new Solution5544();
        String lexSmallestString = solution5544.findLexSmallestString("5525", 9, 2);
        System.out.println(lexSmallestString);
    }




    }

