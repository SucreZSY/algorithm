package com.sucre.swordoffer2.plan1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/16
 */
public class Code_048 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        //每当遇到重复字符， 就将left移动到上一个这个字符位置的下一个, 同时结算子串长度， 直到right超出数组最大下标
        char[] chars = s.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Integer repeatIndex = null;

        while (right < chars.length) {
            repeatIndex = indexMap.get(chars[right]);
            if (repeatIndex == null || repeatIndex < left) {
                maxLength = Math.max(right - left + 1, maxLength);
            } else {
                left = repeatIndex + 1;
            }

            indexMap.put(chars[right], right);
            right++;
        }
        return maxLength;
    }
}
