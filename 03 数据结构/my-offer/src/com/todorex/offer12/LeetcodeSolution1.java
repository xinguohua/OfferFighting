package com.todorex.offer12;

public class LeetcodeSolution1 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //��[i,j]������꿪ʼ����
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //�����ڵ����ֹ����
        //�߽���жϣ����Խ��ֱ�ӷ���false��index��ʾ���ǲ��ҵ��ַ���word�ĵڼ����ַ���
        //�������ַ�������board[i][j]��˵����֤�������·�����߲�ͨ�ģ�ֱ�ӷ���false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;

        //�����������̵���ֹ����
        //���word��ÿ���ַ����������ˣ�ֱ�ӷ���true
        if (index == word.length - 1)
            return true;
        //�ѵ�ǰ�����ֵ����������Ϊ�������ԭ
        char tmp = board[i][j];
        //Ȼ���޸ĵ�ǰ�����ֵ
        board[i][j] = '.';
        //�ߵݹ飬���ŵ�ǰ�������������4���������
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //�ݹ�֮���ٰѵ�ǰ�����긴ԭ
        board[i][j] = tmp;
        return res;
    }


}
