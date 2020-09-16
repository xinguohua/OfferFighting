package com.todorex.offer4;

public class MySolution {
    public static void main(String[] args) {
        //int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix={{-1},{-1}};
        boolean results = new MySolution().findNumberIn2DArray(matrix, -2);
        System.out.println(results);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==1&&matrix[0].length==0||matrix.length==0)
            return false;
        //行数
        int row = matrix.length;
        //列数
        int cloumn = matrix[0].length;

        for (int i = 0; i <row ; i++) {
                //对列进行二分查找
                int rleft=0,rright=cloumn-1;
                while (rleft<=rright){
                    int rmid=(rright+rleft)/2;
                    if (matrix[i][rmid]==target)
                    {return true;}
                    else if(matrix[i][rmid]<target){
                        rleft=rmid+1;
                    } else if(matrix[i][rmid]>target){
                        rright=rmid-1;
                    }
                }




        }
        return false;


    }

}
