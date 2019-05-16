package com.sucre.swordoffer;

import java.util.Stack;

/**
 * 使用两个栈来实现队列
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() != 0){
            return stack2.pop();
        }else if (stack1.size() != 0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            throw new RuntimeException();
        }
    }
}

