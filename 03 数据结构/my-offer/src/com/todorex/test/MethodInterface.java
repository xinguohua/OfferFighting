package com.todorex.test;

//限定接口只能有一个方法
@FunctionalInterface
public interface MethodInterface {

    //这个方法假如就是你想要传递的方法
    public String test(String s);
}
