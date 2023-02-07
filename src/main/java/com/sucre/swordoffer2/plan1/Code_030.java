package com.sucre.swordoffer2.plan1;

import java.util.Stack;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/7
 */
public class Code_030 {
}


/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinStack {
    private Stack<Integer> originStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        originStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        originStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            Integer lastMin = minStack.peek();
            minStack.push(lastMin > x ? x : lastMin);//min栈始终与原始栈一样大, 对应位置始终代表原始栈中这么大的栈范围内最小的元素
        }
    }

    public void pop() {
        originStack.pop();
        minStack.pop();
    }

    public int top() {
        return originStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
