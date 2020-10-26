package com.todorex.week212;

public class Solution5548 {

    //从00开始
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[m][n];
        //从[0,0]开始深度遍历 visited记录是否访问
        int effort=dfs(0, 0, m, n, heights,0, visited);
        return effort;
    }



    public int dfs(int i, int j, int m, int n, int[][] heights,int effort, boolean[][] visited) {

        //1) isArea(i,j,m,n)是边界条件的判断
        //2) isOk(i,j,k)判断当前格子是否是最重点
        //3) visited[i][j]判断这个格子是否被访问过
        if (!isArea(i,j,m,n) || isfinal(i,j,m,n) || visited[i][j])
            //不满足条件返回数量0
            return effort;

        //标注这个格子被访问过
        visited[i][j] = true;
        //沿着当前格子的上下左右继续访问
        int effort1=Math.max(dfs(i + 1, j, m, n, heights,effort,visited),Math.abs(heights[i+1][j]-heights[i][j]));
        int effort2=Math.max(dfs(i-1, j , m, n, heights,effort, visited),Math.abs(heights[i-1][j]-heights[i][j]));
        int effort3=Math.max(dfs(i, j+1 , m, n, heights,effort, visited),Math.abs(heights[i][j+1]-heights[i][j]));
        int effort4=Math.max( dfs(i, j-1 , m, n, heights,effort, visited),Math.abs(heights[i][j-1]-heights[i][j]));
        effort=Math.max(Math.max(effort1,effort2),Math.max(effort3,effort4));
        return effort;
    }

    //判断是否在边界内
    public boolean isArea(int i, int j,int m,int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }else{
            return true;
        }
    }


    //判断这个坐标是否是终点
    public boolean isfinal(int i, int j,int m,int n){
        if(i==m-1&& j == n-1){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        Solution5548 solution5548 = new Solution5548();
        int[][] test=new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(solution5548.minimumEffortPath(test));

    }
}
