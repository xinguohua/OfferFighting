package com.todorex.test;

import org.junit.Test;

public class test {

    @Test
    public void test(){
        Integer mehod = new GenricIntefaceImpl<Integer>().mehod();
        System.out.println(mehod);
    }

    @Test
    public void test1(){
        new TestMethod().test(new Method1(),"test2");
        new TestMethod().test(new Method(),"test1");
    }

    @Test
    public void test2(){
        //testtest
        new TestMethod().test1(s -> {return s+s;},"test");
        // testtesttest
        new TestMethod().test1(s -> {return s+s+s;},"test");
    }





}
