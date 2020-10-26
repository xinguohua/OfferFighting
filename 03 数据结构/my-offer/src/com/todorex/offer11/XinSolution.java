package com.todorex.offer11;



//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

public class XinSolution {


    //最小元素左边元素增加 元素右边增加
    public int minArray(int[] numbers) {

        int pre=numbers[0];
        for(int now:numbers){
            if(now<pre)return now;
            pre=now;
        }
        return numbers[0];
    }

}
