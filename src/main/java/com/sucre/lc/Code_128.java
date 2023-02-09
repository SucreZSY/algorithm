package com.sucre.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/longest-consecutive-sequence/
 * @date 2023/2/9
 */
public class Code_128 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        //动态规划思路 (当i第一次出现时, 其连续最长序列 = (i - 1), (i + 1)的最长序列之和 + 1)

        //并查集思路 用map给数字编号, 假设 X 下标 i, X + 1下标 j 均在nums中出现，需要合并i, j, 但是合并后的根一定要是大的j同时记录集合中的数量
        return longestConsecutiveUseUnionFindSet(nums);
    }

    /**
     * 使用动态规划来处理此问题
     * @param nums
     * @return
     */
    public int longestConsecutiveUseDp(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        //使用map来记录每个数字当前所在连续子序列的长度
        int maxLength = 0;
        Map<Integer, Integer> seqLengthMap = new HashMap<>();
        for (int num : nums) {

        }


        return 1;
    }





    /**
     * 使用并查集的方式记录集合大小以及右边界
     * @param nums
     * @return
     */
    public int longestConsecutiveUseUnionFindSet(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        //用map给数字重新排序
        Map<Integer, Integer> indexMap = new HashMap<>();
        UnionFindSet ufs = new UnionFindSet(nums.length);
        int i = 0;
        while (i < nums.length) {
            //出现过的话说明是重复的, 直接跳过
            if (indexMap.containsKey(nums[i])) {
                i++;
                continue;
            }

            indexMap.put(nums[i], i);
            i++;
        }

        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            Integer num = entry.getKey();
            Integer index = entry.getValue();

            //是否存在num+1
            Integer nextNumIndex = indexMap.get(num + 1);
            if (nextNumIndex == null) {
                continue;
            }
            //存在的话 将num所在集合与num+1集合合并
            ufs.union(index, nextNumIndex);
        }

        return ufs.maxSize();
    }

    public static class UnionFindSet {
        private int[] ans;
        private int[] size;
        int maxSize = 1;

        public UnionFindSet(int num) {
            ans = new int[num];
            size = new int[num];
            int i = 0;
            while (i < num) {
                ans[i] = i;
                size[i++] = 1;
            }
        }

        /**
         * 查询元素的根节点
         * @param i
         * @return
         */
        public int find(int i) {
            if (ans[i] == i) {
                return i;
            } else {
                return (ans[i] = find(ans[i]));
            }
        }

        /**
         * 元素是否在同一个集合中
         * @param i
         * @param j
         * @return
         */
        public boolean inSameSet(int i, int j) {
            return find(i) == find(j);
        }

        /**
         * 合并两个元素 less被合并 more为根
         * @param less
         * @param more
         */
        public void union(int less, int more) {
            int lessAns = find(less);
            int moreAns = find(more);
            if (lessAns == moreAns) {
                return;
            }
            ans[lessAns] = moreAns;
            size[moreAns] += size[lessAns];
            maxSize = Math.max(size[moreAns], maxSize);
        }

        public int maxSize() {
            return maxSize;
        }

    }


}
