package com.todorex.dataStructure.section1;


//最大子列和问题
public class section1_4 {


    public static void main(String[] args) {
        int List[]={-2,11,-4,13,-5,-2,100};
        int i = MaxSubseqSum1(List, 7);
        int m = MaxSubseqSum2(List, 7);
        int k = MaxSubseqSum3(List, 7);
        int l = MaxSubseqSum4(List, 7);
        System.out.println(i);
        System.out.println(m);
        System.out.println(k);
        System.out.println(l);
    }



    //穷举所有子列的和 时间复杂度N3 三层循环
    public static int MaxSubseqSum1(int List[],int N){

        //最大子列的和
        int MaxSum=0;
        //i是子列左端位置
        for (int i = 0; i <N; i++) {
            //j是子列右端位置
            for (int j = i; j <N ; j++) {
                //当前子列的和
                int ThisSum=0;
                //将起始为i,终点为j的序列求和
                for (int k = i; k <=j ; k++) {
                    ThisSum+=List[k];
                }
                if (ThisSum>MaxSum)
                    MaxSum=ThisSum;
            }
        }
        return MaxSum;
    }


    //存储中间部分的值 时间复杂度N2 两层循环
    public static int MaxSubseqSum2(int List[],int N){

        //最大子列的和
        int MaxSum=0;

        //i是子列左端位置
        for (int i = 0; i <N; i++) {
            //当前子列的和
            int ThisSum=0;
            //j是子列右端位置
            for (int j = i; j <N ; j++) {
                //将起始为i,终点为j的序列求和
                ThisSum+=List[j];

                if (ThisSum>MaxSum)
                    MaxSum=ThisSum;
            }
        }
        return MaxSum;
    }


    //三个取最大
    public static int  Max3(int a,int b,int c ){
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }

        if (max < c) {
            max = c;
        }
        return max;
    }

    //分而治之的方法
    public static int DivideAndConquer(int List[],int left,int right){
        int MaxLeftSum,MaxRightSum; //存放左右子问题的解
        int MaxLeftBorderSum=0,MaxRightBorderSum=0; //存放跨越分界线的结果
        int LeftBorderSum=0,RightBorderSum=0;
        int center;
        //递归终止条件
        if (left==right)
        {
            if (List[left]>0)
                return List[left];
            else
                return 0;
        }


        center=(left+right)/2;
        MaxLeftSum=DivideAndConquer(List,left,center);
        MaxRightSum=DivideAndConquer(List,center+1,right);

        for (int i = center; i>=left ; i--) {
            LeftBorderSum =LeftBorderSum+List[i];
            if (LeftBorderSum>MaxLeftBorderSum)
                MaxLeftBorderSum=LeftBorderSum;
        }

        for (int i = center+1; i<=right ; i++) {
            RightBorderSum =RightBorderSum+List[i];
            if (RightBorderSum>MaxRightBorderSum)
                MaxRightBorderSum=RightBorderSum;
        }
        return Max3(MaxLeftSum,MaxRightSum,MaxLeftBorderSum+MaxRightBorderSum);
    }


    public static int MaxSubseqSum3(int List[],int N){


        return DivideAndConquer(List,0,N-1);
    }


    //在线处理
    public static int MaxSubseqSum4(int List[],int N){

        int ThisSum,MaxSum;
        ThisSum=MaxSum=0;
        for (int i = 0; i <N ; i++) {
            ThisSum+=List[i];
            if (ThisSum>MaxSum)
                MaxSum=ThisSum;
            else if (ThisSum<0)
                ThisSum=0;

        }
        return MaxSum;
    }
}
