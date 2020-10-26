package com.todorex.offer11;

public class Solution1 {

        //最小元素左边元素增加 元素右边增加
        public int minArray(int[] numbers) {
            int length = numbers.length;
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
            //特例0：不满足循环条件  旋转0个数字 顺序数组
            while (numbers[i] >= numbers[j]) {

                //跳出循环的条件，两个指针相距为1 第二个指针指向的元素就是值
                if ((j - i) == 1) {
                    middle = j;
                    break;
                }

                middle = (j + i) / 2;



                //特例1
                // 如果下标i, j, middle 指向的第三个数字相等，就只能顺序查找（这个也需要技巧）
                if (numbers[middle] == numbers[i] && numbers[middle] == numbers[j]) {
                    return minNumberArray(numbers, i, j);
                }


                //特例2：middle指向的值与左（右）指针元素相等的情况
                // 通常是大于 或是 小于
                if (numbers[middle] >= numbers[i]) {
                    i = middle;
                } else if (numbers[middle] <= numbers[j]){
                    j = middle;
                }

            }

            return numbers[middle];
        }


        /**
         * 顺序找出旋转数组中最小的值
         * 因为有序，只要找到第一个递减的值就可以返回了
         * @param numbers
         * @param index1
         * @param index2
         * @return
         */
        public int minNumberArray(int [] numbers, int index1, int index2) {
            int result = numbers[index1];
            for (int i = index1; i < index2-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    return numbers[i+1];
                }
            }
            // 都是递增返回第一个
            return result;
        }

    /**
     * 顺序扫描
     * @param numbers
     * @param index1
     * @param index2
     * @return
     */
    public int minNumberArray1(int [] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1; i < index2; i++) {
            if (numbers[i] < result) {
                result =numbers[i];
            }
        }
        return result;
    }
    }

