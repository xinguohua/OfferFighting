package com.todorex.dataStructure.section3.section332;

public class test {

    public static void main(String[] args) {
        SeqStack<Integer> integerSeqStack = new SeqStack<Integer>(Integer.class,20);
        System.out.println(integerSeqStack.empty());
        System.out.println(integerSeqStack.push(1));
        System.out.println(integerSeqStack.push(2));
        System.out.println(integerSeqStack.peek());
        System.out.println(integerSeqStack.pop());
        System.out.println(integerSeqStack.size());
        System.out.println("=========================");
        LinkStack<Integer> integerLinkStack = new LinkStack<>();
        System.out.println(integerLinkStack.empty());
        System.out.println(integerLinkStack.push(1));
        System.out.println(integerLinkStack.push(2));
        System.out.println(integerLinkStack.peek());
        System.out.println(integerLinkStack.pop());
        System.out.println(integerLinkStack.size());

    }
}
