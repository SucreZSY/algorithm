package com.sucre.lc;

import sun.font.GlyphLayout;

/**
 * @author sucre
 * @desc leetcode第5题
 * @see https://leetcode.cn/problems/longest-palindromic-substring/?favorite=2cktkvj
 * @date 2022/9/2
 */
public class Code_005 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *              
     *
     *     示例 1：
     *
     *     输入：s = "babad"
     *     输出："bab"
     *     解释："aba" 同样是符合题意的答案。
     *     示例 2：
     *
     *     输入：s = "cbbd"
     *     输出："bb"
     *              
     *
     *     提示：
     *          1 <= s.length <= 1000
     *          s 仅由数字和英文字母组成
     */
    public String longestPalindrome(String s) {
        /**
         * 回文字符串，最大的特点就是从中间开始往两边用双指针的话， 指针指向的字符是一样的
         *  1. 可以使用中心扩散法进行求解，每一位向两边进行扩散， 扩散到最长子串为止， 存储最长回文子串， 遍历完之后返回
         *  2. 可以使用动态规划， 用 boolean dp[i][j] 代表 从i到j这一位是否是回文串, 则计算dp[i-1][j+1]只需要推导计算i-1和j+1字符是否一致即可
         */
        //解法1
        return centralDiffusion(s);
    }

    /**
     * 中心扩散法求解
     * @param originStr
     * @return
     */
    private String centralDiffusion(String originStr) {
        if (originStr == null) {
            return null;
        }
        int length = originStr.length();
        if (length == 1) {
            return originStr;
        }
        char[] chars = originStr.toCharArray();
        String longestPalindrome = String.valueOf(chars[0]);
        int index = 0;
        while (index < length) {
            String tempDiffusion = diffusion(chars, index);
            if (tempDiffusion.length() > longestPalindrome.length()) {
                longestPalindrome = tempDiffusion;
            }
            index++;
        }
        return longestPalindrome;
    }

    /**
     * 扩散
     * @param chars
     * @param index
     * @return
     */
    private String diffusion(char[] chars, int index) {
        if (chars == null) {
            return "";
        }
        int length = chars.length;
        if (index >= length) {
            return "";
        }
        if (index == 0) {
            return String.valueOf(chars[index]);
        }

        //向左/向右扩散 永远代表回文的边界下标，只有left right对应的字符一样才会递增
        int left = index;
        int right = index;

        //可能回文中心是完全一样的偶数长度字符串,先扩散
        while (chars[left - 1] == chars[right]) {
            left = left - 1;
            if (left == 0) {
                break;
            }
        }

        while (chars[left] == chars[right]) {
            if (left == 0 || right == (length - 1)) {
                break;
            }
            if (chars[left - 1] == chars[right + 1]) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return new String(chars, left, right - left + 1);
    }
}
