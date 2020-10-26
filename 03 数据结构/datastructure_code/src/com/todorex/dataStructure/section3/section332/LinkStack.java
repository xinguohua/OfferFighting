package com.todorex.dataStructure.section3.section332;



//链表实现的栈
public class LinkStack<E> implements IStack<E> {
    private StackNode<E> top; // 栈顶指示器
    private int size; // 栈中结点的个数

    // 初始化链栈
    public LinkStack() {
        top = null;
        size = 0;
    }

    // 判断顺序栈是否为空
    public boolean empty() {
        if ((top == null) && (size == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // 入栈操作
    public E push(E item) {
        StackNode<E> newnode = new StackNode<E>(item);
        if (!empty())
            newnode.setNext(top);
        top = newnode;
        ++size;
        return item;
    }

    // 出栈操作
    public E pop() {
        E item=null;
        if (!empty())
        {
            item = top.getData();
            top = top.getNext();
            size--;
        }
        return item;
    }
    // 获取栈顶数据元素
    public E peek() {
        E item=null;
        if (!empty())
        {
            item=top.getData();
        }
        return item;
    }

    // 求栈的长度
    public int size() {
        return size;
    }

}