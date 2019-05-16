package com.sucre.algorithm.QueueAndStack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> realStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public boolean push(int element){
        realStack.push(element);
        if (minStack.size() == 0){
            minStack.push(element);
            return true;
        }
        Integer min = minStack.peek();
        Integer e = min <= element ? minStack.push(min) : minStack.push(element);
        if (e != null) return true;
        return false;
    }
    public int pop(){
        minStack.pop();
        return realStack.pop();
    }
    public int peek(){
        return realStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(7);
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(3);
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(4);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
