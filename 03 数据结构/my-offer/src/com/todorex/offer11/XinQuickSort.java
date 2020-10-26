package com.todorex.offer11;

import java.util.Random;

public class XinQuickSort {


    public static void main(String[] args) throws Exception {


        int[] a = new int[] {5, 10, -324, 86,  -7, 26,  78,  90,  8,  0, -1,  20,  30, -5};

        // 数组，数组长度，起始索引，终止索引
        quickSort(a, 14, 0, 13);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }



    /**
     * 利用分区递归函数实现快速排序
     * 递归
     * @param data 数组
     * @param length 数组长度
     * @param start 开始索引
     * @param end 终止索引
     * @throws Exception
     */
    public static void quickSort(int[] data, int length, int start, int end) throws Exception {

        //递归终止条件
        // 当只剩一个数的时候就不用递归了
        if (start == end) {
            return;
        }
        //找到中间位置
        int index = partition(data, length, start, end);
        // 防止异常
        if (index > start) {
            //排序左半部分
            quickSort(data, length, start, index - 1);
        }
        if (index < end) {
            //排序右半部分
            quickSort(data, length, index + 1, end);
        }

    }



    /**
     * 分区函数
     * 按随机出的基准值分区，将比基准值小放在基准值左边，大的放在基准值右边
     * @param data 数据
     * @param length 数组长度
     * @param start 排序开始索引
     * @param end 排序结束索引
     * @return
     * @throws Exception
     */
    public static int partition(int data[], int length, int start, int end) throws Exception {

        Random random = new Random();

        if (data == null || length <=0 || start <0 || end >= length) {
            throw new Exception("Invalid Parameters");
        }

        // 尽量避免极端情况，在start和end之间随机出一个数
        int index = start + random.nextInt(end - start + 1);

        // 每次都是以最后一个数字作为基准值，将比较的值放在数组的最后
        swap(data, index, end);

        // 定义一个指针，指向所有换序之后所有比基准值都小的数据的最右边，最后最指向基准值应该在位置
        int small = start - 1;

        for (int i = start; i < end; i++) {
            // 和基准值（end）作比较
            if (data[i] < data[end]) {
                small++;
                // 避免原来就是有序数列的无用交换
                if (small != i) {
                    swap(data, small, i);
                }
            }
        }
        // 把基准值放在中间
        small++;
        swap(data, small, end);
        return small;
    }




    /**
     * 交换数组中的两个值
     * @param array
     * @param index1
     * @param index2
     */
    public static void swap (int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
