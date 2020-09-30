package com.todorex.offer6;

import java.util.*;

public class XinSolution {
    public  static  int[] reversePrint(ListNode head) {

        if(head ==null){
            return new int[]{};
        }

        LinkedList<Integer> stack =new LinkedList<>();
        ListNode p=head;

        while(p!=null){
            stack.push(p.val);
            p=p.next;

        }
        //链表长度
        int count=stack.size();
        int[] res = new int[count];
        for (int i = 0; i <count ; i++) {
            int pop = stack.pop();
            res[i]=pop;

        }
        return res;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        head.next=node1;
        node1.next=node2;

        reversePrint(head);
    }
}
