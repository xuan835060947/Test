package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/23.
 */

public class LeetCode19 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode = removeNthFromEnd(listNode, 2);
        print(listNode);
        listNode = removeNthFromEnd(listNode, 2);
        print(listNode);
        listNode = removeNthFromEnd(listNode, 1);
        print(listNode);
    }

    private void print(ListNode listNode){
        while (listNode != null) {
            PrintUtil.print("" + listNode.val);
            if (listNode.next == null) {
                break;
            }
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while (n-- >= 1) {//first 在N的前面
            if (second.next == null && n == 0) {//删除Head
                head = head.next;
                return head;
            }
            second = second.next;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }


        first.next = first.next.next;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
