package com.todorex.offer5;


//由于每次替换从 1 个字符变成 3 个字符，使用字符数组可方便地进行替换。建立字符数组地长度为 s 的长度的 3 倍，这样可保证字符数组可以容纳所有替换后的字符。
//
//        获得 s 的长度 length
//        创建字符数组 array，其长度为 length * 3
//        初始化 size 为 0，size 表示替换后的字符串的长度
//        从左到右遍历字符串 s
//        获得 s 的当前字符 c
//        如果字符 c 是空格，则令 array[size] = '%'，array[size + 1] = '2'，array[size + 2] = '0'，并将 size 的值加 3
//        如果字符 c 不是空格，则令 array[size] = c，并将 size 的值加 1
//        遍历结束之后，size 的值等于替换后的字符串的长度，从 array 的前 size 个字符创建新字符串，并返回新字符串

public class LeetCodeSolution {

    public String replaceSpace(String s) {
        char[] chars = new char[s.length()*3];
        int size=0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)==' '){
                chars[size]='%';
                chars[size+1]='2';
                chars[size+2]='0';
                size=size+3;
            }else{
                chars[size++]=s.charAt(i);
            }
        }
        return new String(chars);
    }
}
