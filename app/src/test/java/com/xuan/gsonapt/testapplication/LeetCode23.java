package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/27.
 */

public class LeetCode23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(7);
        listNode1.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(5);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(4);
        listNode3.next.next = new ListNode(5);

        ListNode[] listNodes = new ListNode[5];
        listNodes[0] = listNode1;
        listNodes[1] = listNode2;
        listNodes[2] = listNode3;
        listNodes[3] = new ListNode(2);
        listNodes[4] = new ListNode(100);
        ListNode result = mergeKLists(listNodes);
        print(result);

    }

    private void print(ListNode result) {
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int end = (lists.length + 1) / 2;
        int newLength = lists.length;
        while (end > 0) {
            for (int i = 0; i < end; i++) {
                int left = i * 2;
                int right = left + 1;
                if (right < newLength) {
                    lists[i] = merge(lists[left], lists[right]);
                } else {
                    lists[i] = lists[left];
                }
            }
            newLength = end;
            if (end != 1) {
                end = (end + 1) / 2;
            } else {
                end = 0;
            }
        }

        return lists[0];
    }


    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode head = left;

        if (left.val > right.val) {
            ListNode temp = left;
            left = right;
            right = temp;
            head = left;
        }

        while (left.next != null) {
            if (left.next.val > right.val) {
                ListNode temp = left.next;
                left.next = right;
                right = temp;
            }
            left = left.next;
        }

        left.next = right;
        return head;
    }
}
