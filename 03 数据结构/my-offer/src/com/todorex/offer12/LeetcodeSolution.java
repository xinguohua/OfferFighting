package com.todorex.offer12;

public class LeetcodeSolution {

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
        //�߽���жϣ����Խ��ֱ�ӷ���false��index��ʾ���ǲ��ҵ��ַ���word�ĵڼ����ַ���
        //�������ַ�������board[i][j]��˵����֤�������·�����߲�ͨ�ģ�ֱ�ӷ���false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        //���word��ÿ���ַ����������ˣ�ֱ�ӷ���true
        if (index == word.length - 1)
            return true;
        //Ϊ�˷�ֹ��֧��Ⱦ����board���鸴��һ��
        char[][] newArra = copyArray(board);
        //��newArra[i][j]��Ϊ������ţ���ʾ�Ѿ���ʹ�ù���(ע�⣺word�в��ܰ���'.')
        newArra[i][j] = '.';
        //�ӵ�ǰ��������������ĸ��������
        boolean res = dfs(newArra, word, i + 1, j, index + 1) || dfs(newArra, word, i - 1, j, index + 1) ||
                dfs(newArra, word, i, j + 1, index + 1) || dfs(newArra, word, i, j - 1, index + 1);
        return res;
    }

    //����һ���µ�����
    private char[][] copyArray(char[][] word) {
        char[][] newArray = new char[word.length][word[0].length];
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[0].length; j++) {
                newArray[i][j] = word[i][j];
            }
        }
        return newArray;
    }



}
