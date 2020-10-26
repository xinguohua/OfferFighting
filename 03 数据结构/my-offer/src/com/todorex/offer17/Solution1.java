package com.todorex.offer17;

/**
 * 打印从1到最大的n位数
 *
 * @Author rex
 * 2018/7/22
 */
public class Solution1 {
    /**
     * 在字符串上模拟数字加法的解法
     *
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        // 防止非法输入
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        initCharArray(number);
        //字符串数组上模拟加法，并返回是否溢出
        while (!increment(number)) {
            printNumber(number);
        }
    }



    /**
     * 初始化字符数组
     *
     * 使其每个字符初始为'0'
     * @param chars
     */
    public void initCharArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }
    }


    /**
     * 字符串表示的数字上模拟加法
     * @param number
     * @return
     */
    private boolean increment(char[] number) {
        // 是否超出999....
        boolean isOverflow = false;
        // 进位数
        int takeOver = 0;
        for (int i = number.length-1; i >= 0; i--) {
            int nsum = number[i] - '0' + takeOver;
            //最低位+1
            if (i == number.length-1) {
                nsum++;
            }
            //进位
            if (nsum >= 10) {
                //最高位
                if (i == 0) {
                    isOverflow = true;
                } else {
                    //进位后恢复成原来的样本 13--->3 进位1
                    nsum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + nsum);
                }
            } else { //不进位的情况
                number[i] = (char) ('0' + nsum);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 根据字符串打印出数字
     * @param number
     */
    private void printNumber(char[] number) {
        // 默认字符串不以0开始
        boolean isBegining0 = true;

        for (int i = 0; i < number.length; i++) {
            if (isBegining0 && number[i] != '0') {
                isBegining0 = false;
            }
            if (!isBegining0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }



}
