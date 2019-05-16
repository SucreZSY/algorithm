package com.sucre.algorithm.QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;
@SuppressWarnings("all")
public class TwoQueueStack {
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public Integer peek(){
        if (queue.size() == 0) throw new RuntimeException("noElement");
        while (queue.size() != 1){
            Integer temp = queue.poll();
            help.add(temp);
        }
        Integer res = queue.poll();
        help.add(res);
        swap();//保证queue永远指向有值的，help永远指向空的
        return res;
    }
    public Integer pop(){
        if (queue.size() == 0) throw new RuntimeException("noElement");
        while (queue.size() != 1){
            Integer temp = queue.poll();
            help.add(temp);
        }
        Integer res = queue.poll();
        swap();//保证queue永远指向有值的，help永远指向空的
        return res;
    }
    public boolean push(Integer element){
        queue.add(element);
        return true;
    }
    public void swap(){
        Queue<Integer> temp = help;
        help = queue;
        queue = temp;
    }

    public static void main(String[] args) {
        TwoQueueStack s = new TwoQueueStack();
        s.push(1);
        s.push(3);
        s.push(5);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
