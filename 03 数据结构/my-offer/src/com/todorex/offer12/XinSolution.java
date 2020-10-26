package com.todorex.offer12;

import java.util.HashMap;

//递归题
//每一步有四种情况 左、右、上、下
// 最基本的情况
public class XinSolution {
    public boolean exist(char[][] board, String word) {


        char[] chars = word.toCharArray();


        char c=chars[0];
        boolean FindFirst=false;
        boolean FindOthers=false;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(c==board[i][j]){
                    int[][] indicate = new int[200][200];
                    FindFirst=true;

                    //一个元素直接返回
                    if (word.length()==0)
                        return FindFirst;
                    int k=1;
                    FindOthers = findOthers(board, word, i, j,k,indicate);
                    if(FindOthers)
                        return FindFirst&&FindOthers;


                }
            }
        }

        return FindFirst&&FindOthers;
    }

    private boolean findOthers(char[][] board,String word,int i,int j,int k ,int[][] indicate) {
        //递归终止条件
        if (k==word.length())
            return true;

        boolean left = false;
        boolean right =false;
        boolean top =false;
        boolean bottom= false;
        //每一步有四种情况 左、右、上、下
        indicate[i][j]=1;
        if (i>0&&board[i-1][j] ==word.charAt(k)&&indicate[i-1][j]!=1) {
            k++;

            top = findOthers(board, word, i - 1, j, k,indicate);
            if (top==true)
            {
                return top;
            }
            k--;
        }
        if (i+1<board.length&&board[i+1][j] ==word.charAt(k)&&indicate[i+1][j]!=1) {
            k++;

            bottom =findOthers(board, word, i + 1, j, k,indicate);
            if (bottom==true)
            {
                return bottom;
            }
            k--;
        }
        if (j>0&&board[i][j-1] ==word.charAt(k)&&indicate[i][j-1]!=1) {
            k++;

            left =findOthers(board, word, i, j - 1, k,indicate);
            if (left==true)
            {
                return left;
            }
            k--;
        }
        if (j+1<board[i].length&&board[i][j+1] ==word.charAt(k)&&indicate[i][j+1] !=1) {
            k++;

            right =findOthers(board, word, i, j + 1, k,indicate);

            if (right==true)
            {
                return right;
            }
            k--;
        }

        indicate[i][j]=0;
        return left||right||bottom||top;

    }


    public static void main(String[] args) {
        //char[][] board=new char[][]{{'a','b'}};
        //char[][] board1=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //char[][] board1=new char[][]{{'A'}};
        //char[][] board1=new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        char[][] board1=new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        //boolean results = new XinSolution().exist(board, "ab");
        //boolean results1 = new XinSolution().exist(board1, "AB");
//        boolean results1 = new XinSolution().exist(board1, "AAB");
        boolean results1 = new XinSolution().exist(board1, "ABCESEEEFS");
        System.out.println(results1);


    }
}
