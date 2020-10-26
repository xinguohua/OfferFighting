package com.todorex.dataStructure.section4.section412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch{



    public  int binarySearchMethod(List<Integer> Tb1,int k){
        int left,right,mid;

        left=0; //初始左边界
        right=Tb1.size()-1; //初始右边界

        //查找条件就是左右边界之间包含元素
        while (left<=right){
            mid=(left+right)/2;
            //跳出条件就是判断mid
            int midvalue=Tb1.get(mid).intValue();
            if (midvalue==k){
                return mid;
            }else if (k<midvalue){
                right=mid-1;
            }else if (midvalue<k){
                left=mid+1;
            }


        }
        //查找不成功
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        //排序的一定是有序序列
        integers.add(5);
        integers.add(16);
        integers.add(20);
        int i = new BinarySearch().binarySearchMethod(integers, 3);
        System.out.println(i);
    }

}
