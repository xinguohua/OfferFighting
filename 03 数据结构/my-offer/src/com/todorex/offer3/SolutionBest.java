package com.todorex.offer3;

import java.util.HashMap;

public class SolutionBest {
    public int findRepeatNumber(int[] nums) {
        // 杜绝数组为空
        if (nums.length == 0) {
            return -1;
        }
        // 杜绝数组有非法数字
        //数组 nums 里的所有数字都在 0～n-1 的范围内
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //当扫描到下标为i的数字，首先比较这个数字（用m表示）是不是等于i
            while (nums[i] != i) {
                //如果和第m个方法数组相等 即m位置和i位置相等，存在重复数字返回
                if (nums[i] == nums[nums[i]]) {
                    nums[0] = nums[i];
                    return nums[0];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        nums[0] = -1;
        return nums[0];
    }
}
