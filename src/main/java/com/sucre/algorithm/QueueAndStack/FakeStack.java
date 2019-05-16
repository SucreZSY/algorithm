package com.sucre.algorithm.QueueAndStack;

public class FakeStack {
    private int[] stack;//底层数组
    private int capacity;//容量
    private int position;//栈顶
    private int size;//实际大小
    public FakeStack(int capacity){
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    /**
     * 压栈的方法
     * @param element 被压元素
     * @return 是否压入成功
     */
    public boolean push(int element){
        if (size + 1 > capacity){
            throw new RuntimeException("outOfAllowedSize");
        }
        stack[position++] = element;
        size++;
        return true;
    }

    /**
     * @return 弹出栈顶元素
     */
    public int pop(){
        if (position == 0) throw new RuntimeException("noElementStored");
        size--;
        return stack[--position];
    }

    /**
     * @return 获取但不弹出栈顶元素
     */
    public int peek(){
        if (position == 0) throw new RuntimeException("noElementStored");
        return stack[position - 1];
    }

    public static void main(String[] args) {
        FakeStack stack = new FakeStack(3);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
