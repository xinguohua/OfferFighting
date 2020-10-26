package com.todorex.offer13;


//深度优先遍历DFS
public class LeetcodeSolution {
    public int movingCount(int m, int n, int k) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[m][n];
        //从[0,0]开始深度遍历 visited记录是否访问
        int count=dfs(0, 0, m, n, k, visited);
        return count;
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        int count=0;
        //1) isArea(i,j,m,n)是边界条件的判断
        //2) isOk(i,j,k)判断当前格子坐标是否满足条件
        //3) visited[i][j]判断这个格子是否被访问过
        if (!isArea(i,j,m,n) || !isOk(i,j,k) || visited[i][j])
            //不满足条件返回数量0
            return count;

        //标注这个格子被访问过
        visited[i][j] = true;
        //沿着当前格子的上下左右继续访问
        count=1 + dfs(i + 1, j, m, n, k, visited) + dfs(i-1, j , m, n, k, visited)+dfs(i, j+1 , m, n, k, visited)+dfs(i, j-1 , m, n, k, visited);
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
