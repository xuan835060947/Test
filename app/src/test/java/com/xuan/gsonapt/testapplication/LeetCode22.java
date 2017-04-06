package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenxiaoxuan1 on 17/3/24.
 */

public class LeetCode22 {


    @Test
    public void test() {
        List<String> list = new LinkedList<>();
        list.add("()");
        mList = new LinkedList<>();
        Assert.assertEquals(list, generateParenthesis(1));
        list = new LinkedList<>();
        list.add("(())");
        list.add("()()");
        mList = new LinkedList<>();
        Assert.assertEquals(list, generateParenthesis(2));
    }

    private List<String> mList = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
//        add(new StringBuilder(), n, n);
        nonRecursive(n);
        return mList;
    }

    private void add(StringBuilder stringBuilder, int left, int right) {
        if (left > 0) {
            StringBuilder temp = new StringBuilder(stringBuilder);
            temp.append("(");
            add(temp, left - 1, right);
        }
        if (right > left) {
            StringBuilder temp = new StringBuilder(stringBuilder);
            temp.append(")");
            add(temp, left, right - 1);
        }
        if (left == 0 && right == 0) {
            mList.add(stringBuilder.toString());
        }
    }


    private void nonRecursive(int n) {
        Stack<Node> stack = new Stack<>();
        Node node = new Node();
        node.left = n;
        node.right = n;
        node.stringBuilder = new StringBuilder();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node item = stack.pop();
            if (item.left == 0 && item.right == 0) {
                mList.add(item.stringBuilder.toString());
            } else {
                if(item.left > 0){
                    Node leftNode = new Node();
                    leftNode.left =item.left -1;
                    leftNode.right = item.right;
                    leftNode.stringBuilder = new StringBuilder(item.stringBuilder);
                    leftNode.stringBuilder.append("(");
                    stack.push(leftNode);
                }
                if(item.right > item.left){
                    Node rightNode = new Node();
                    rightNode.left =item.left;
                    rightNode.right = item.right - 1;
                    rightNode.stringBuilder = new StringBuilder(item.stringBuilder);
                    rightNode.stringBuilder.append(")");
                    stack.push(rightNode);
                }
            }
        }

    }

    private class Node {
        int left;
        int right;
        StringBuilder stringBuilder;
    }
}
