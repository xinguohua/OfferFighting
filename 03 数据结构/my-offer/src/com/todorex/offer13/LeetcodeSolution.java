package com.todorex.offer13;


//������ȱ���DFS
public class LeetcodeSolution {
    public int movingCount(int m, int n, int k) {
        //��ʱ����visited��¼�����Ƿ񱻷��ʹ�
        boolean[][] visited = new boolean[m][n];
        //��[0,0]��ʼ��ȱ��� visited��¼�Ƿ����
        int count=dfs(0, 0, m, n, k, visited);
        return count;
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        int count=0;
        //1) isArea(i,j,m,n)�Ǳ߽��������ж�
        //2) isOk(i,j,k)�жϵ�ǰ���������Ƿ���������
        //3) visited[i][j]�ж���������Ƿ񱻷��ʹ�
        if (!isArea(i,j,m,n) || !isOk(i,j,k) || visited[i][j])
            //������������������0
            return count;

        //��ע������ӱ����ʹ�
        visited[i][j] = true;
        //���ŵ�ǰ���ӵ��������Ҽ�������
        count=1 + dfs(i + 1, j, m, n, k, visited) + dfs(i-1, j , m, n, k, visited)+dfs(i, j+1 , m, n, k, visited)+dfs(i, j-1 , m, n, k, visited);
        return count;
    }

    //�ж������������ֵĺ��Ƿ�������Ҫ
    public boolean isOk(int i, int j,int k){
        int ans = i % 10 + i / 10 + j % 10 + j /10;
        return ans <= k;
    }

    //�ж��Ƿ��ڱ߽���
    public boolean isArea(int i, int j,int m,int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }else{
            return true;
        }
    }
}
