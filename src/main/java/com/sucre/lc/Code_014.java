package com.sucre.lc;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/longest-common-prefix/
 * @date 2023/2/6
 */
public class Code_014 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Integer minLength = null;
        for (String str : strs) {
            if (minLength == null) {
                minLength = str.length();
            } else {
                minLength = Math.min(str.length(), minLength);
            }
        }

        int index = 0;
        StringBuilder answer = new StringBuilder("");
        while (index < minLength) {
            char c = strs[0].charAt(index);
            for (String str : strs) {
                char cInOther = str.charAt(index);
                if (c != cInOther) {
                    return answer.toString();
                }
            }
            answer.append(c);
            index++;
        }
        return answer.toString();
    }
}
