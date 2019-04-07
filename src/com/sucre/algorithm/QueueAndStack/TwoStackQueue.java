package com.sucre.algorithm.QueueAndStack;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> help = new Stack<>();
    public Integer peek(){
        if (help.size() == 0){
            pull();
        }
        return help.peek();
    }
    public Integer poll(){
        if (help.size() == 0){
            pull();
        }
        return help.pop();
    }
    public boolean offer(Integer element){
        stack.push(element);
        return true;
    }
    private void pull(){
        if (stack.size() == 0){
            throw new RuntimeException("noElement");
        }
        while (stack.size() != 0){
            Integer pop = stack.pop();
            help.push(pop);
        }
    }

    public static void main(String[] args) {
        TwoStackQueue q = new TwoStackQueue();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q.peek());
        q.offer(5);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
