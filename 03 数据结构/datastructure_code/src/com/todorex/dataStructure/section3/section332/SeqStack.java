package com.todorex.dataStructure.section3.section332;

import java.lang.reflect.Array;
//栈的顺序实现
public class SeqStack<E> implements IStack<E> {
    private int maxsize; // 顺序栈的最大容量
    private E[] data; // 数组，用于存储顺序栈中的数据元素
    private int top; // 指示顺序栈的栈顶

    // 初始化栈
    @SuppressWarnings("unchecked")
    public SeqStack(Class<E> type, int size) {
        data = (E[]) Array.newInstance(type, size);
        maxsize = size;
        top = -1;
    }
    // 判断顺序栈是否为空
    public boolean empty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
    // 判断顺序栈是否为满
    public boolean isFull() {
        if (top == maxsize - 1) {
            return true;
        } else {
            return false;
        }
    }

    // 入栈操作
    public E push(E item) {
        if (!isFull()) {
            data[++top] = item;
            return item;
        }
        else
            return null;
    }
    // 出栈操作
    public E pop() {
        E item = null;
        if (!empty()) {
            item = data[top--];
        }
        return item;
    }

    // 获取栈顶数据元素
    public E peek() {
        E item = null;
        if (!empty()) {
            item = data[top];
        }
        return item;
    }
    //求栈的长度
    public int size() {
        return top+1;
    }


}
