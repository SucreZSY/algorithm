package com.sucre.swordoffer2.plan1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/23
 */
public class Code_41 {


}

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 */
class MedianFinder {
    private PriorityQueue<Integer> minQueue;
    private PriorityQueue<Integer> maxQueue;


    /** initialize your data structure here. */
    public MedianFinder() {
        minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    //保证max的数量 >= min
    public void addNum(int num) {
        if (minQueue.size() != maxQueue.size()) {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        } else {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
    }

    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        } else {
            if (minQueue.size() == 0) {
                return 0;
            }
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
