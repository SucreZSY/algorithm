package com.sucre.swordoffer2.plan1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/11
 */
public class Code_050 {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例 1:
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     *
     * 输入：s = ""
     * 输出：' '
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return ' ';
        }
        Map<Character, Boolean> singleMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (singleMap.containsKey(aChar)) {
                singleMap.put(aChar, false);
            } else {
                singleMap.put(aChar, true);
            }
        }
        for (char aChar : chars) {
            Boolean single = singleMap.get(aChar);
            if (single) {
                return aChar;
            }
        }
        return ' ';
    }
}
