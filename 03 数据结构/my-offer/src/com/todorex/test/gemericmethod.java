package com.todorex.test;

import java.util.ArrayList;

//泛型方法
public class gemericmethod {

    public static void main(String[] args) {

        /**不指定泛型的时候*/
        int i = gemericmethod.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f = gemericmethod.add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o = gemericmethod.add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

//        /**指定泛型的时候*/
//        int a = gemericmethod.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
//        int b = gemericmethod.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
//        Number c = gemericmethod.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
        ArrayList arrayList = new ArrayList();
        arrayList.add('1');
        arrayList.add(1);
        System.out.println(arrayList);
    }


    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }


}
