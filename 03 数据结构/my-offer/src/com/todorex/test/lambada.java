package com.todorex.test;

public class lambada {

    public static void main(String[] args) {

        display(s -> {s=s+"1";return s;},"test");
    }



    public static void display(MethodInterface method,String s){
        System.out.println(method.test(s));
    }

}
