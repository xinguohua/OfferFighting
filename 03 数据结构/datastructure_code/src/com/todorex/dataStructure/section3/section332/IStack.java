package com.todorex.dataStructure.section3.section332;

public interface IStack<E> {
    E push(E item); //入栈
    E pop(); //出栈
    E peek(); //取栈顶元素
    int size(); //返回栈中元素的个数
    boolean empty(); //判断栈是否为空
}
