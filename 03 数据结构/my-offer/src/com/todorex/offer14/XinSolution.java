package com.todorex.offer14;

/**
 * 给你一根长度为 n 的绳子
 * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 */



/**
 * DFS+缓存
 */
public class XinSolution {
    /**
     * 长度为n,
     * @param n
     * @return
     */
    public int Dfs(int n, int[] mem) {

        //DFS整个遍历终止的条件
        //长度为2 乘积为1
        if (n <= 2) {
            return 1;
        }

        //如果记忆数组 存在长度为n数组的值直接返回
        if (mem[n] != 0) {
            return mem[n];
        }

        int res = 0;
        //遍历所有的子节点 就是所哟分段的情况
        for (int length = 2; length < n; ++length) { // 从2开始即可
            // 当前层不分割
            res = Math.max(res, length * (n -length));
            // 当前层继续递归分割, 取最大值
            res = Math.max(res, length * Dfs(n - length, mem));
        }
        mem[n] = res;
        return res;
    }

    public int cuttingRope(int n){
        //记忆数组： 记录长度为n的乘积结果
        int[] mem = new int[n+1];
        //从n开始出发
        int res = Dfs(n, mem);
        return res;
    }


}
