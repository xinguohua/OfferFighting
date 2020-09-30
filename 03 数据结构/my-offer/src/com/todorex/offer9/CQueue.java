package com.todorex.offer9;


import java.util.LinkedList;

//栈 先进后出
//队列 先进先出
public class CQueue {
    LinkedList<Integer> stack;
    LinkedList<Integer> stack1;

    public CQueue() {
        stack = new LinkedList<>();
        stack1 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                stack1.push(pop);
            }
            int val = stack1.pop();

            while (!stack1.isEmpty()) {
                Integer pop1 = stack1.pop();
                stack.push(pop1);
            }
            return val;
        }


    }

}
