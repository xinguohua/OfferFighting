package com.todorex.offer13;

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeSolution1 {

    public int movingCount(int m, int n, int k) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        //创建一个队列，保存的是访问到的格子坐标，是个二维数组
        Queue<int[]> queue = new LinkedList<>();

        //从左上角坐标[0,0]点开始访问，add方法表示把坐标
        // 点加入到队列的队尾
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            //这里的remove()函数表示的是移除队列头部元素，因为队列
            // 是先进先出，从尾部添加，从头部移除
            int[] x = queue.remove();
            int i = x[0], j = x[1];

            //1) isArea(i,j,m,n)是边界条件的判断
            //2) isOk(i,j,k)判断当前格子坐标是否满足条件
            //3) visited[i][j]判断这个格子是否被访问过
            //不满足以上任意条件直接进入下一次循环
            if (!isArea(i,j,m,n)|| !isOk(i,j,k) || visited[i][j])
                continue;
            //标注这个格子被访问过
            visited[i][j] = true;
            count++;
            //把当前格子右边格子的坐标加入到队列中
            queue.add(new int[]{i + 1, j});
            //左
            queue.add(new int[]{i - 1, j});
            //下
            queue.add(new int[]{i, j+1});
            //把当前格子上边格子的坐标加入到队列中
            queue.add(new int[]{i, j -1});
        }
        return count;
    }

    //判断两个坐标数字的和是否满足需要
    public boolean isOk(int i, int j,int k){
        int ans = i % 10 + i / 10 + j % 10 + j /10;
        return ans <= k;
    }

    //判断是否在边界内
    public boolean isArea(int i, int j,int m,int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }else{
            return true;
        }
    }


}
