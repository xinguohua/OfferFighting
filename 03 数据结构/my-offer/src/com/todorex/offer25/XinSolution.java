package com.todorex.offer25;

// �ϲ�����
public class XinSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dump = new ListNode(0);
        ListNode cur=dump;
        while (head1 != null && head2 != null) {
            if (head2.val >= head1.val) {
                cur.next=head1;
                cur=cur.next;
                head1=head1.next;
            } else {
                cur.next=head2;
                cur=cur.next;
                head2=head2.next;
            }
        }

        //1 ʣ�� 2 ʣ��
        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }
        return dump.next;
    }
}
