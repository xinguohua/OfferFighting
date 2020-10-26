package com.todorex.dataStructure.section1;


//多项式算法
public class section1_1b {


    //多项式的最大项数
    static int MAXN=3;
    //被测函数最大重复调用次数
    static int MAXK=100;


    //测试被测函数运行的时间
    public static  void run(MethodInterface methodInterface,double a[],double x){

        long startTime = System.currentTimeMillis(); //程序开始记录时间
        for (int i = 0; i <MAXK ; i++) {
            //Java中方法作为参数解耦合
            double v = methodInterface.f(MAXN - 1, a, x);
            if (i==0)
                System.out.println(v);

        }
        long endTime = System.currentTimeMillis(); //程序结束记录时间
        long TotalTime = endTime - startTime; //总消耗时间
        System.out.println(TotalTime);

    }


    public static void main(String[] args) {
        double a[]=new double [MAXN];
        for (int i = 0; i <MAXN ; i++) {
             a[i]=(double)i;
        }
        //run(new f1(),a,2);
        run(new f2(),a,2);

    }








}
