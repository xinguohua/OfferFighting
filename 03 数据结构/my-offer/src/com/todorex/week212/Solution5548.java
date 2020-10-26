package com.todorex.week212;

public class Solution5548 {

    //��00��ʼ
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        //��ʱ����visited��¼�����Ƿ񱻷��ʹ�
        boolean[][] visited = new boolean[m][n];
        //��[0,0]��ʼ��ȱ��� visited��¼�Ƿ����
        int effort=dfs(0, 0, m, n, heights,0, visited);
        return effort;
    }



    public int dfs(int i, int j, int m, int n, int[][] heights,int effort, boolean[][] visited) {

        //1) isArea(i,j,m,n)�Ǳ߽��������ж�
        //2) isOk(i,j,k)�жϵ�ǰ�����Ƿ������ص�
        //3) visited[i][j]�ж���������Ƿ񱻷��ʹ�
        if (!isArea(i,j,m,n) || isfinal(i,j,m,n) || visited[i][j])
            //������������������0
            return effort;

        //��ע������ӱ����ʹ�
        visited[i][j] = true;
        //���ŵ�ǰ���ӵ��������Ҽ�������
        int effort1=Math.max(dfs(i + 1, j, m, n, heights,effort,visited),Math.abs(heights[i+1][j]-heights[i][j]));
        int effort2=Math.max(dfs(i-1, j , m, n, heights,effort, visited),Math.abs(heights[i-1][j]-heights[i][j]));
        int effort3=Math.max(dfs(i, j+1 , m, n, heights,effort, visited),Math.abs(heights[i][j+1]-heights[i][j]));
        int effort4=Math.max( dfs(i, j-1 , m, n, heights,effort, visited),Math.abs(heights[i][j-1]-heights[i][j]));
        effort=Math.max(Math.max(effort1,effort2),Math.max(effort3,effort4));
        return effort;
    }

    //�ж��Ƿ��ڱ߽���
    public boolean isArea(int i, int j,int m,int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }else{
            return true;
        }
    }


    //�ж���������Ƿ����յ�
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
