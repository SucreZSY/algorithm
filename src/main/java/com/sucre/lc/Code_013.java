package com.sucre.lc;

import java.util.*;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/roman-to-integer/
 * @date 2023/2/6
 */
public class Code_013 {

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "III"
     * 输出: 3
     * 示例 2:
     *
     * 输入: s = "IV"
     * 输出: 4
     * 示例 3:
     *
     * 输入: s = "IX"
     * 输出: 9
     * 示例 4:
     *
     * 输入: s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     *
     * 输入: s = "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        /**
         * 反向匹配罗马数字
         * M - 1000
         * CM - 900
         * D - 500
         * CD - 400
         * C - 100
         * XC - 90
         * L - 50
         * XL - 40
         * X - 10
         * IX - 9
         * V - 5
         * IV - 4
         * I - 1
         */

        Map<String, Integer> mappingMap = new HashMap<>();
        mappingMap.put("M", 1000);
        mappingMap.put("CM", 900);
        mappingMap.put("D", 500);
        mappingMap.put("CD", 400);
        mappingMap.put("C", 100);
        mappingMap.put("XC", 90);
        mappingMap.put("L", 50);
        mappingMap.put("XL", 40);
        mappingMap.put("X", 10);
        mappingMap.put("IX", 9);
        mappingMap.put("V", 5);
        mappingMap.put("IV", 4);
        mappingMap.put("I", 1);

        int finalNum = 0;
        char[] chars = s.toCharArray();
        Character lastChar = null;
        int lastNum = 0;
        for (char aChar : chars) {
            Integer currentNum = mappingMap.get(String.valueOf(aChar));
            if (lastChar == null) {
                lastChar = aChar;
                lastNum = currentNum;
            } else {
                if (lastNum < currentNum) {//特殊规则
                    finalNum = finalNum + mappingMap.get(lastChar + String.valueOf(aChar));
                    lastChar = null;
                    lastNum = 0;
                } else {//正常规则
                    finalNum = finalNum + lastNum;
                    lastChar = aChar;
                    lastNum = currentNum;
                }
            }
        }
        return finalNum + lastNum;
    }
}
