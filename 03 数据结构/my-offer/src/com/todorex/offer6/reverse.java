package com.todorex.offer6;

public class reverse {

    public int[] reversePrint(ListNode head) {

        //非递归方式反转链表
        // pre 为新链表从前向后遍历的节点指针
        ListNode pre = null;
        //记录链表的长度
        int count=0;
        //head为旧链表从前向后遍历的节点指针
        while (head != null) {

            //next记录遍历到节点的下一位置,因为要对当前节点的下一节点重新赋值
            ListNode next = head.next;
            //next指针重新指向
            head.next = pre;

            //两个指针不断向后移
            pre = head;
            head = next;
            count++;
        }


       int[] res =new int[count];

        int i=0;
        while (pre!=null){
            res[i]=pre.val;
            pre=pre.next;
        }
        return res;
    }



    




}
