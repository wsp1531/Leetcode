package com.csii.leetcode;

import com.csii.wsp.ListNode;


public class No_Leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        while(l1.next!=null||l2.next!=null){
            ListNode tmp;
            while(l1.next!=null&&l2.next!=null){
                tmp=new ListNode(l1.val+l2.val);

            }
        }




        return null;
    }
}
