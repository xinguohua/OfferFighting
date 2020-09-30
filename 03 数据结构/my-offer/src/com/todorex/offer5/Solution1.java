package com.todorex.offer5;

/**
 * 替换空格
 * 从后往前（降低时间复杂度）
 * @Author rex
 * 2018/6/10
 */
public class Solution1 {

    /**
     * @Author rex
     * @Date 2018/6/10 下午4:24
     * @Description 替换空格
     * 利用两个指针从后往前替换
     * @param str 输入字符串
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int oldLength = str.length();
        // 扩展StringBuffer 统计空格的数量 如果遇到空格 增加两个空字符
        for (int i = 0; i < oldLength; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int newLength = str.length();
        //p1 指向原字符串尾部元素
        int p1 = oldLength - 1;

        //p2 指向新字符串尾部元素
        int p2 = newLength - 1;

        //当两个 指针相遇时 说明所有空格字符都添加完了
        while (p1 != p2) {
            if (str.charAt(p1) == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
                p1--;
            } else {
                str.setCharAt(p2--, str.charAt(p1--));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are happy.")));
    }

}

