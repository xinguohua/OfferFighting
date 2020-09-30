package com.todorex.offer6;

public class reverseDigui {


    private int count=0;
    public int[] reversePrint(ListNode head) {

        //调用递归
        ListNode pre = reverseList(head);
        int[] res =new int[count];

        int i=0;
        while (pre!=null){
            res[i]=pre.val;
            pre=pre.next;
        }
        return res;
    }


    public ListNode reverseList(ListNode head) {

        //递归的终止条件
        if (head == null || head.next == null)
            return head;

        //开始递归
        ListNode tempList = reverseList(head.next);

        count++;
        //递归结束的代码
        head.next.next = head;
        head.next = null;
        return tempList;
    }





}
