package com.todorex.offer11;

/**
 * 旋转数组的最小数字
 * @Author rex
 * 2018/7/19
 */

public class Solution {
    /**
     * 获取旋转数组的最小数字
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if(length == 0) {
            return 0;
        }
        // i永远为前一个非递减的数组指针
        int i= 0;
        // j永远为后一个非递减的数组指针
        int j= length-1;
        // middle永远指向中间的值，当旋转数据就是原数组时，返回第1个数字
        int middle = 0;

        //二分查找循环的条件变了 第一个指针指向的值一定大于第二个指针指向的值
        //不满足循环条件 就是特例1 旋转0个数字 顺序数组
        while (array[i] >= array[j]) {

            //跳出循环的条件，两个指针相距为1 第二个指针就是值
            if ((j - i) == 1) {
                middle = j;
                break;
            }

            middle = (j + i) / 2;

            // 如果下标i, j, middle 指向的第三个数字相等，就只能顺序查找（这个也需要技巧）
            if (array[middle] == array[i] && array[middle] == array[j]) {
                return minNumberArray(array, i, j);
            }

            if (array[middle] >= array[i]) {
                i = middle;
            } else if (array[middle] <= array[j]){
                j = middle;
            }
        }

        return array[middle];
    }


    /**
     * 顺序找出旋转数组中最小的值
     * 因为有序，只要找到第一个递减的值就可以返回了
     * @param array
     * @param index1
     * @param index2
     * @return
     */
    public static int minNumberArray(int [] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1; i < index2-1; i++) {
            if (array[i] > array[i+1]) {
                return array[i+1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,1,1,0,1};
        System.out.println(minNumberInRotateArray(array));
    }
}
