package com.sucre.lc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/integer-to-roman/
 * @date 2023/2/6
 */
public class Code_012 {
    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: num = 3
     * 输出: "III"
     * 示例 2:
     *
     * 输入: num = 4
     * 输出: "IV"
     * 示例 3:
     *
     * 输入: num = 9
     * 输出: "IX"
     * 示例 4:
     *
     * 输入: num = 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     *
     * 输入: num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        /**
         * 参考思路: 可以使用贪心， 优先匹配数值大的数据 https://leetcode.cn/problems/integer-to-roman/solution/tan-xin-ha-xi-biao-tu-jie-by-ml-zimingmeng/
         *
         * 可使用的映射表
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
        LinkedHashMap<Integer, String> mappingMap = new LinkedHashMap<>();
        mappingMap.put(1000, "M");
        mappingMap.put(900, "CM");
        mappingMap.put(500, "D");
        mappingMap.put(400, "CD");
        mappingMap.put(100, "C");
        mappingMap.put(90, "XC");
        mappingMap.put(50, "L");
        mappingMap.put(40, "XL");
        mappingMap.put(10, "X");
        mappingMap.put(9, "IX");
        mappingMap.put(5, "V");
        mappingMap.put(4, "IV");
        mappingMap.put(1, "I");

        StringBuilder answer = new StringBuilder();
        for (Map.Entry<Integer, String> entry : mappingMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            int count = num / key;
            num = num % key;
            while (count > 0) {
                answer.append(value);
                count--;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(100));
        System.out.println(intToRoman(599));
        System.out.println(intToRoman(3098));
    }
}
