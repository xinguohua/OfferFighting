package com.todorex.offer18;

public class XinSolution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head ==null)
            return null;
        if (head.val==val){
                head=head.next;
            }
        ListNode pre=head;
        ListNode temp=head.next;
        while(temp!=null){
           if (temp.val==val)
           {
               pre.next=temp.next;
               break;
               }
           pre= pre.next;
           temp=temp.next;
         }




            return head;
    }
}

