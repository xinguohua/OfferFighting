package com.todorex.offer22;

import java.util.LinkedList;

public class XinSolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp=head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }

        return stack.get(k-1);
    }
}
