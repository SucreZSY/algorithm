package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/27
 */
public class Code_021 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 50000
     * 0 <= nums[i] <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int maxOddIndex = -1;
        int currentIndex = nums.length - 1;

        while (maxOddIndex < currentIndex) {
            if (isOdd(nums[currentIndex])) {
                swap(nums, ++maxOddIndex, currentIndex);
            } else {
                currentIndex--;
            }
        }
        return nums;
    }
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
    int temp;
    public void swap(int[] nums, int a, int b) {
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
