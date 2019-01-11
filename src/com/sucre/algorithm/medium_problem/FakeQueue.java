package com.sucre.algorithm.medium_problem;

import java.util.Arrays;

public class FakeQueue {
    private int[] queue;
    private int capacity;
    private int size;
    private int position;
    private int index;

    public FakeQueue(int capacity){
        this.queue = new int[capacity];
        this.capacity = capacity;
    }
    public boolean offer(int element){
        if (size + 1 > capacity) throw new RuntimeException("outOfBoundException");
        if (position == capacity) position = 0;//position永远指向队列尾部+1的位置，如果他是和capacity相等的话就说明他应该在0的位置
        queue[position++] = element;
        size++;
        return true;
    }
    public int poll(){
        if (size == 0) throw new RuntimeException("noElementStored");
        size--;
        if (index == capacity) index = 0;
        return queue[index++];
    }
    public int peek(){
        if (size == 0) throw new RuntimeException("noElementStored");
        return queue[index];
    }

    @Override
    public String toString() {
        return "FakeQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    public static void main(String[] args) {
        FakeQueue queue = new FakeQueue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.toString());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
