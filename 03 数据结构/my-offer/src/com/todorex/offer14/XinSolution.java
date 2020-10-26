package com.todorex.offer14;

/**
 * ����һ������Ϊ n ������
 * ������Ӽ����������ȵ� m �Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1]...k[m-1] ��
 * ���� k[0]*k[1]*...*k[m-1] ���ܵ����˻��Ƕ��٣����磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ�
 * ��ʱ�õ������˻���18��
 */



/**
 * DFS+����
 */
public class XinSolution {
    /**
     * ����Ϊn,
     * @param n
     * @return
     */
    public int Dfs(int n, int[] mem) {

        //DFS����������ֹ������
        //����Ϊ2 �˻�Ϊ1
        if (n <= 2) {
            return 1;
        }

        //����������� ���ڳ���Ϊn�����ֱֵ�ӷ���
        if (mem[n] != 0) {
            return mem[n];
        }

        int res = 0;
        //�������е��ӽڵ� ������Ӵ�ֶε����
        for (int length = 2; length < n; ++length) { // ��2��ʼ����
            // ��ǰ�㲻�ָ�
            res = Math.max(res, length * (n -length));
            // ��ǰ������ݹ�ָ�, ȡ���ֵ
            res = Math.max(res, length * Dfs(n - length, mem));
        }
        mem[n] = res;
        return res;
    }

    public int cuttingRope(int n){
        //�������飺 ��¼����Ϊn�ĳ˻����
        int[] mem = new int[n+1];
        //��n��ʼ����
        int res = Dfs(n, mem);
        return res;
    }


}
