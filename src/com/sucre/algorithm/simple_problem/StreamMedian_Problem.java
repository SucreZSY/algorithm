package com.sucre.algorithm.simple_problem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 随时获取一个流中的中位数的类，流是一个个的吐出一个数出来，因此要不断收集这些数
 * 放到数据结构中存储起来，因此这里一个类对象为一个流进行服务，不用静态方法
 */
public class StreamMedian_Problem {
    private boolean res;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;//o1大的话返回正数，放后面，小根堆
        }
    });
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;//o1大的情况返回负数，放前面，大根堆
        }
    });

    /**
     * 把元素存入堆结构中
     * @param e 待入堆元素
     */
    public void elementToHeap(Integer e){
        res = (maxHeap.peek() == null || maxHeap.peek() > e) ? maxHeap.add(e) : minHeap.add(e);//添加res是为了让三元成功
        if (!res) throw new RuntimeException("添加失败");
        if ((maxHeap.size() - minHeap.size()) > 1){//如果小的那一部分要长2，就弹出最大的加到大的那部分去
            Integer max = maxHeap.poll();
            minHeap.add(max);
        }
        if ((minHeap.size() - maxHeap.size()) > 1){
            Integer min = minHeap.poll();
            maxHeap.add(min);
        }
    }

    /**
     * 求已经出现的所有元素中的中位数
     * @return 中位数
     */
    public Integer getMedian(){
        Integer median = 0;
        if (maxHeap.size() == 0) {
            return null;//为什么这里要直接返回? 防止两个都是空的时候干扰下面的操作
        }
        median = maxHeap.size() == minHeap.size() ? (maxHeap.peek() + ((minHeap.peek() - maxHeap.peek()) >> 1)) : median;
        median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : median;
        median = maxHeap.size() < minHeap.size() ? minHeap.peek() : median;
        return median;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,12,3};
        StreamMedian_Problem median = new StreamMedian_Problem();
        for (int i : arr) {
            median.elementToHeap(i);
            System.out.println("第" + i +"次计算中位数：" + median.getMedian());
        }

    }
}
