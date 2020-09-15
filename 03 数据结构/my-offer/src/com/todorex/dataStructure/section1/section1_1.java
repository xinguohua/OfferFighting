package com.todorex.dataStructure.section1;

public class section1_1 {

    public static void main(String[] args) {

        Print(100);

    }

    //循环打印1->N的方法
    public static void Print(int N){

        for (int i = 1; i <=N ; i++) {
            System.out.println(i);

        }
    }

    //递归打印1->N的方法
    public static void Print2(int N){

        if (N>0){
            Print2(N-1);
            System.out.println(N);
        }
    }
}
