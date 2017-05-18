package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by chenxiaoxuan1 on 17/4/12.
 */

public class reverseStack {

    @Test
    public void test(){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverStack(stack);

        while (!stack.isEmpty()){
            PrintUtil.print(""+stack.pop()+" ");
        }
    }


    public void reverStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            Integer i = stack.pop();
            reverStack(stack);
            addToBottom(stack,i);
        }
    }

    public void addToBottom(Stack<Integer> stack,Integer a){
        if(stack.isEmpty()){
            stack.push(a);
        }else {
            Integer pop = stack.pop();
            addToBottom(stack,a);
            stack.push(pop);
        }
    }
}
