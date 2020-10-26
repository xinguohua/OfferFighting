package com.todorex.offer13;

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeSolution1 {

    public int movingCount(int m, int n, int k) {
        //��ʱ����visited��¼�����Ƿ񱻷��ʹ�
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        //����һ�����У�������Ƿ��ʵ��ĸ������꣬�Ǹ���ά����
        Queue<int[]> queue = new LinkedList<>();

        //�����Ͻ�����[0,0]�㿪ʼ���ʣ�add������ʾ������
        // ����뵽���еĶ�β
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            //�����remove()������ʾ�����Ƴ�����ͷ��Ԫ�أ���Ϊ����
            // ���Ƚ��ȳ�����β����ӣ���ͷ���Ƴ�
            int[] x = queue.remove();
            int i = x[0], j = x[1];

            //1) isArea(i,j,m,n)�Ǳ߽��������ж�
            //2) isOk(i,j,k)�жϵ�ǰ���������Ƿ���������
            //3) visited[i][j]�ж���������Ƿ񱻷��ʹ�
            //������������������ֱ�ӽ�����һ��ѭ��
            if (!isArea(i,j,m,n)|| !isOk(i,j,k) || visited[i][j])
                continue;
            //��ע������ӱ����ʹ�
            visited[i][j] = true;
            count++;
            //�ѵ�ǰ�����ұ߸��ӵ�������뵽������
            queue.add(new int[]{i + 1, j});
            //��
            queue.add(new int[]{i - 1, j});
            //��
            queue.add(new int[]{i, j+1});
            //�ѵ�ǰ�����ϱ߸��ӵ�������뵽������
            queue.add(new int[]{i, j -1});
        }
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
